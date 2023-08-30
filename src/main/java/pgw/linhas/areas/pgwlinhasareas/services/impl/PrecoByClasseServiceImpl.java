package pgw.linhas.areas.pgwlinhasareas.services.impl;

import org.springframework.stereotype.Service;
import pgw.linhas.areas.pgwlinhasareas.dtos.PrecoDto;
import pgw.linhas.areas.pgwlinhasareas.models.PrecoByClasse;
import pgw.linhas.areas.pgwlinhasareas.repositories.PrecosByClasseRepository;
import pgw.linhas.areas.pgwlinhasareas.services.PrecoByClasseService;
import pgw.linhas.areas.pgwlinhasareas.util.Util;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PrecoByClasseServiceImpl implements PrecoByClasseService {
    Util util = new Util();
    final PrecosByClasseRepository precosByClasseRepository;

    public PrecoByClasseServiceImpl(PrecosByClasseRepository precosByClasseRepository) {
        this.precosByClasseRepository = precosByClasseRepository;
    }

    @Transactional
    public PrecoByClasse cadastrarPrecos(PrecoDto precoDto) {
        PrecoByClasse precoByClasse = new PrecoByClasse();
        util.copiarPropriedades(precoDto, precoByClasse);
        return precosByClasseRepository.save(precoByClasse);
    }
    public List<PrecoByClasse> recuperarPrecos(){
        return precosByClasseRepository.findAll();
    }
    public PrecoByClasse alterarPreco(long id, PrecoDto precoDto){
        PrecoByClasse precoByClasse = new PrecoByClasse();
        Optional<PrecoByClasse> optional = precosByClasseRepository.findById(id);
        precoByClasse = optional.get();
        precoByClasse.setClasseNome(precoDto.getClasseNome());
        precoByClasse.setQtdAssentos(precoDto.getQtdAssentos());
        precoByClasse.setValorAssento(precoDto.getValorAssento());
        return precosByClasseRepository.save(precoByClasse);
    }
}
