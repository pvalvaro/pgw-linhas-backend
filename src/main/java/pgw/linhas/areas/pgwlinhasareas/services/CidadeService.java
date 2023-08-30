package pgw.linhas.areas.pgwlinhasareas.services;

import org.springframework.stereotype.Service;
import pgw.linhas.areas.pgwlinhasareas.dtos.CidadeDTO;
import pgw.linhas.areas.pgwlinhasareas.models.Cidade;

@Service
public interface CidadeService {
    Cidade cadastrarCidade(CidadeDTO cidadeDTO);
}
