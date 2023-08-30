package pgw.linhas.areas.pgwlinhasareas.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pgw.linhas.areas.pgwlinhasareas.dtos.CidadeDTO;
import pgw.linhas.areas.pgwlinhasareas.dtos.ClasseDTO;
import pgw.linhas.areas.pgwlinhasareas.models.Cidade;
import pgw.linhas.areas.pgwlinhasareas.models.Classe;
import pgw.linhas.areas.pgwlinhasareas.repositories.ClasseRepository;
import pgw.linhas.areas.pgwlinhasareas.services.ClasseService;
import pgw.linhas.areas.pgwlinhasareas.util.Util;

import javax.transaction.Transactional;
import java.lang.annotation.Annotation;

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
        util.copiarPropriedades(classeDTO,classe);
        return classeRepository.save(classe);
    }

}