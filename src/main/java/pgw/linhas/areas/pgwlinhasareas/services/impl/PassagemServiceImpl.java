package pgw.linhas.areas.pgwlinhasareas.services.impl;

import org.springframework.stereotype.Service;
import pgw.linhas.areas.pgwlinhasareas.dtos.CompraPassagemDTO;
import pgw.linhas.areas.pgwlinhasareas.dtos.PassagemDto;
import pgw.linhas.areas.pgwlinhasareas.models.*;
import pgw.linhas.areas.pgwlinhasareas.repositories.*;
import pgw.linhas.areas.pgwlinhasareas.services.PassagemService;
import pgw.linhas.areas.pgwlinhasareas.util.Util;

import java.util.*;

@Service
public class PassagemServiceImpl implements PassagemService {
   final PassagemRepository passagemRepository;
   final ClasseRepository classeRepository;
   final VooRepository vooRepository;
    final PassageiroRepository passageiroRepository;
    final VisitanteRepository visitanteRepository;
    public PassagemServiceImpl(PassagemRepository passagemRepository, ClasseRepository classeRepository, VooRepository vooRepository, PassageiroRepository passageiroRepository, VisitanteRepository visitanteRepository) {
        this.passagemRepository = passagemRepository;
        this.classeRepository = classeRepository;
        this.vooRepository = vooRepository;
        this.passageiroRepository = passageiroRepository;
        this.visitanteRepository = visitanteRepository;
    }


    Util util = new Util();
    Map<String, Passagem> passagemListaCompradas = new HashMap<>();
    List<PassagemDto> passagemDtoList = new ArrayList<>();

    @Override
    public List<Passagem> comprarPassagem(CompraPassagemDTO dto) {
        Passagem passagem = new Passagem();

        Voo voo = vooRepository.findById(dto.getVooId()).get();
        dto.setVoo(voo);

        //persisitir visitante
        Visitante visitante =  visitanteRepository.save(dto.getVisitante());
        dto.setVisitante(visitante);

        double valorPorPassagem = (double) dto.getTotalValor() / dto.getPassageiros().size();
        dto.setTotalValor(valorPorPassagem);

        Classe classe = classeRepository.findById(dto.getClasseId()).get();
        Passagem passgemSalva = new Passagem();

        for (Passageiro passageiro: dto.getPassageiros()) {
            util.copiarPropriedades(dto, passagem);
            passagem.setPassageiro(passageiro);
            passagem.setPassagemNumero("PWG"+passageiro.getCpf());
            passagem.setClasse(classe);
            passgemSalva = passagemRepository.save(passagem);
            passagemListaCompradas.put("'"+ passgemSalva.getPassagemNumero()+"'", passgemSalva);
            passgemSalva = new Passagem();
            passagem = new Passagem();
        }

        List<Passagem> passagensCompradas = new ArrayList<>(passagemListaCompradas.values());

        //atualizar voo
        Integer totalAssentosAtualizacao = voo.getTotalAssentos() -  passagensCompradas.size();
        voo.setTotalAssentos(totalAssentosAtualizacao);
        vooRepository.save(voo);
        return passagensCompradas;
    }

    public CompraPassagemDTO calculo(CompraPassagemDTO dto){
        List<Classe> classeList = classeRepository.findAll();
        double valorAssento = 0;
        double valorBagagemExtra;

        for (Classe classe: classeList) {
            if (dto.getClasseId().equals(classe.getId())) {
                valorAssento = classe.getValorAssento();
            }
        }

        if(dto.isBagagemDespachada()){
            double porcentagemByBagagem = valorAssento * 0.1;      //Calcula os 10% de cada bagagem extra
            valorBagagemExtra = dto.getQtdBagagem() * porcentagemByBagagem;
            dto.setValorBagagem(valorBagagemExtra);
            dto.setTotalValor( ( valorAssento + valorBagagemExtra)* dto.getPassageiros().size());
        }else{
            dto.setTotalValor(valorAssento * dto.getPassageiros().size());
        }
        return dto;
    }

    @Override
    public Optional<Passagem> findById(long id) {
        return passagemRepository.findById(id);
    }

    @Override
    public List<PassagemDto> recuperarTodosPassageiros() {
        passagemDtoList = new ArrayList<>();
        List<Passagem> passagemList = passagemRepository.findAll();
        PassagemDto dto = new PassagemDto();
        for (Passagem passagem: passagemList) {
            util.copiarPropriedades(passagem, dto);
            passagemDtoList.add(dto);
        }
        return passagemDtoList;
    }

    @Override
    public List<PassagemDto> recuperarPassagensCPFComprador(String cpf) {
        passagemDtoList = new ArrayList<>();
        List<Passagem> passagemList = passagemRepository.recuperarPassagensCPFComprador(cpf);
        PassagemDto dto = new PassagemDto();
        for (Passagem passagem: passagemList) {
            util.copiarPropriedades(passagem, dto);
            passagemDtoList.add(dto);
        }
        return passagemDtoList;
    }

    @Override
    public List<PassagemDto> recuperarPassagemVoo(String codigo) {
        passagemDtoList = new ArrayList<>();
        List<Passagem> passagemList = passagemRepository.recuperarPassagemVoo(codigo);
        PassagemDto dto = new PassagemDto();
        for (Passagem passagem: passagemList) {
            util.copiarPropriedades(passagem, dto);
            passagemDtoList.add(dto);
        }
        return passagemDtoList;
    }

    @Override
    public Passagem cancelar(PassagemDto passagemDto, Optional<Passagem> optional) {
        Passagem passagemAtual = optional.get();
        //passagemAtual.setStatusPassagem(passagemDto.getStatusPassagem());
        return passagemRepository.save(passagemAtual);
    }
}
