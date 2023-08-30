package pgw.linhas.areas.pgwlinhasareas.services.impl;

import org.springframework.stereotype.Service;
import pgw.linhas.areas.pgwlinhasareas.Execptions.PgwExecptions;
import pgw.linhas.areas.pgwlinhasareas.dtos.CompraPassagemDTO;
import pgw.linhas.areas.pgwlinhasareas.dtos.VooDto;
import pgw.linhas.areas.pgwlinhasareas.models.Aeroporto;
import pgw.linhas.areas.pgwlinhasareas.models.Classe;
import pgw.linhas.areas.pgwlinhasareas.models.Voo;
import pgw.linhas.areas.pgwlinhasareas.repositories.AeroportoRepository;
import pgw.linhas.areas.pgwlinhasareas.repositories.ClasseRepository;
import pgw.linhas.areas.pgwlinhasareas.repositories.VooRepository;
import pgw.linhas.areas.pgwlinhasareas.services.VooService;
import pgw.linhas.areas.pgwlinhasareas.util.Util;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VooServiceImpl implements VooService {

    Util util = new Util();
    final VooRepository vooRepository;
    final AeroportoRepository aeroportoRepository;
    final ClasseRepository classeRepository;

    public VooServiceImpl(VooRepository vooRepository, AeroportoRepository aeroportoRepository, ClasseRepository classeRepository) {
        this.vooRepository = vooRepository;
        this.aeroportoRepository = aeroportoRepository;
        this.classeRepository = classeRepository;
    }
    @Transactional
    public Voo cadastrarVoos(VooDto vooDto) {
        Voo voo = new Voo();

        util.copiarPropriedades(vooDto, voo);


        //busca os aeroportos
        Aeroporto origem = aeroportoRepository.findById(vooDto.getOrigem_id()).get();
        voo.setOrigem(origem);
        Aeroporto destino = aeroportoRepository.findById(vooDto.getDestino_id()).get();
        voo.setDestino(destino);

        //busca as todas as classes disponibilizadas pela companhia
        List<Classe> classeList = new ArrayList<>();
        classeList =classeRepository.findAll();
        for (Classe classe: classeList) {
           if(classe.getTipoClasse().equals("Economica"))
               voo.setEconomica(classe);

            if(classe.getTipoClasse().equals("Primeira"))
                voo.setPrimeira(classe);

            if(classe.getTipoClasse().equals("Executiva"))
                voo.setExecutiva(classe);
        }
        Integer somaAssentos = voo.getEconomica().getQuantidadeAssentos() +
                voo.getExecutiva().getQuantidadeAssentos() + voo.getPrimeira().getQuantidadeAssentos();
        if(somaAssentos > voo.getTotalAssentos()){
            throw new PgwExecptions("Voo com capacidade total excedida");
        }

        return vooRepository.save(voo);
    }
    public Voo alterarVoo(VooDto vooDto, Optional<Voo> vooOptional){
        Voo vooAtualizacao = vooOptional.get();
        /*vooAtualizacao.setPartida(vooDto.getPartida());
        vooAtualizacao.setChegada(vooDto.getChegada());
        vooAtualizacao.setQtdAssentoEconomica(vooDto.getQtdAssentoEconomica());
        vooAtualizacao.setQtdAssentoPrimeira(vooDto.getQtdAssentoPrimeira());
        vooAtualizacao.setQtdAssentoExecutiva(vooDto.getQtdAssentoExecutiva());
        vooAtualizacao.setPrecoAssentoPrimeira(vooDto.getPrecoAssentoPrimeira());
        vooAtualizacao.setPrecoAssentoEconomica(vooDto.getPrecoAssentoEconomica());
        vooAtualizacao.setPrecoAssentoExecutiva(vooDto.getPrecoAssentoExecutiva());
        vooAtualizacao.setEconomica(vooDto.getEconomica());
        vooAtualizacao.setPrimeira(vooDto.getPrimeira());
        vooAtualizacao.setExecutiva(vooDto.getExecutiva());*/
        return vooRepository.save(vooAtualizacao);
    }
    public List<VooDto> recuperarVoos(){
        List<Voo> vooList = vooRepository.findAll();
        List<VooDto> vooDtoList = new ArrayList<>();
        for (Voo voo: vooList) {
            vooDtoList.add(VooDto.convertVooToDTO(voo));
        }
        return vooDtoList;
    }
    public Optional<Voo> findById(long id) {
        return vooRepository.findById(id);
    }
    @Override
    public Voo cancelar(VooDto vooDto) {
        Voo voo = new Voo();
        util.copiarPropriedades(vooDto, voo);
        return vooRepository.save(voo);
    }
}
