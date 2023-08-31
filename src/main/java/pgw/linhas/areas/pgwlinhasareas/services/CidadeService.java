package pgw.linhas.areas.pgwlinhasareas.services;

import org.springframework.stereotype.Service;
import pgw.linhas.areas.pgwlinhasareas.dtos.CidadeDTO;
import pgw.linhas.areas.pgwlinhasareas.models.Cidade;

import java.util.List;

@Service
public interface CidadeService {
    Cidade cadastrarCidade(CidadeDTO cidadeDTO);
    List<Cidade> recuperarTodasCidades();
}
