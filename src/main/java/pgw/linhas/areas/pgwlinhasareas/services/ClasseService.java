package pgw.linhas.areas.pgwlinhasareas.services;

import org.springframework.stereotype.Service;
import pgw.linhas.areas.pgwlinhasareas.dtos.ClasseDTO;
import pgw.linhas.areas.pgwlinhasareas.models.Classe;

@Service
public interface ClasseService {
    Classe cadastrarClasse(ClasseDTO classeDTO);
}
