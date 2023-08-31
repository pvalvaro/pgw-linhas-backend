package pgw.linhas.areas.pgwlinhasareas.services.impl;

import org.springframework.stereotype.Service;
import pgw.linhas.areas.pgwlinhasareas.dtos.CidadeDTO;
import pgw.linhas.areas.pgwlinhasareas.models.Cidade;
import pgw.linhas.areas.pgwlinhasareas.repositories.CidadeRepository;
import pgw.linhas.areas.pgwlinhasareas.services.CidadeService;
import pgw.linhas.areas.pgwlinhasareas.util.Util;

import java.util.List;

@Service
public class CidadeServiceImpl implements CidadeService {
    Util util = new Util();
    final CidadeRepository cidadeRepository;
    public CidadeServiceImpl(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    @Override
    public Cidade cadastrarCidade(CidadeDTO cidadeDTO) {
        Cidade cidade = new Cidade();
        util.copiarPropriedades(cidadeDTO,cidade);
        return cidadeRepository.save(cidade);
    }

    @Override
    public List<Cidade> recuperarTodasCidades() {
        return cidadeRepository.findAll();
    }
}
