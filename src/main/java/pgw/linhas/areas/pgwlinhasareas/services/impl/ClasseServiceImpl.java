package pgw.linhas.areas.pgwlinhasareas.services.impl;

import org.springframework.stereotype.Service;
import pgw.linhas.areas.pgwlinhasareas.dtos.ClasseDTO;
import pgw.linhas.areas.pgwlinhasareas.models.Classe;
import pgw.linhas.areas.pgwlinhasareas.repositories.ClasseRepository;
import pgw.linhas.areas.pgwlinhasareas.services.ClasseService;
import pgw.linhas.areas.pgwlinhasareas.util.Util;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClasseServiceImpl implements ClasseService {
    Util util = new Util();
    private final ClasseRepository classeRepository;

    public ClasseServiceImpl(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Transactional
    public Classe cadastrarClasse(ClasseDTO classeDTO) {
        Classe classe = new Classe();
        util.copiarPropriedades(classeDTO, classe);
        return classeRepository.save(classe);
    }

    @Transactional
    @Override
    public Object alterarPreco(Long id, ClasseDTO classeDTO) {
        return null;
    }

    public List<Classe> recuperarPrecos() {
        return classeRepository.findAll();
    }

    @Transactional
    public Classe alterarPreco(long id, ClasseDTO classeDTO) {
        Classe classe = new Classe();
        Optional<Classe> optional = classeRepository.findById(id);
        classe = optional.get();
        classe.setTipoClasse(classeDTO.getTipoClasse());
        classe.setValorAssento(classeDTO.getValorAssento());
        classe.setQuantidadeAssentos(classeDTO.getQuantidadeAssentos());
        return classeRepository.save(classe);
    }
}