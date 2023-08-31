package pgw.linhas.areas.pgwlinhasareas.services;

import org.springframework.stereotype.Service;
import pgw.linhas.areas.pgwlinhasareas.dtos.ClasseDTO;
import pgw.linhas.areas.pgwlinhasareas.models.Classe;

import java.util.List;

@Service
public interface ClasseService {
    Classe cadastrarClasse(ClasseDTO classeDTO);
    List<Classe> recuperarPrecos();
    Object alterarPreco(Long id, ClasseDTO classeDTO);
}
