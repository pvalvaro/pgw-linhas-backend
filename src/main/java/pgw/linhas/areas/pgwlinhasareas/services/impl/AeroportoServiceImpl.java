package pgw.linhas.areas.pgwlinhasareas.services.impl;

import org.springframework.stereotype.Service;
import pgw.linhas.areas.pgwlinhasareas.dtos.AeroportoDTO;
import pgw.linhas.areas.pgwlinhasareas.models.Aeroporto;
import pgw.linhas.areas.pgwlinhasareas.models.Cidade;
import pgw.linhas.areas.pgwlinhasareas.repositories.AeroportoRepository;
import pgw.linhas.areas.pgwlinhasareas.repositories.CidadeRepository;
import pgw.linhas.areas.pgwlinhasareas.services.AeroportoService;
import pgw.linhas.areas.pgwlinhasareas.util.Util;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AeroportoServiceImpl implements AeroportoService {
    Util util = new Util();

    final AeroportoRepository aeroportoRepository;
    final CidadeRepository cidadeRepository;

    public AeroportoServiceImpl(AeroportoRepository aeroportoRepository, CidadeRepository cidadeRepository) {
        this.aeroportoRepository = aeroportoRepository;
        this.cidadeRepository = cidadeRepository;
    }

    @Transactional
    public Aeroporto cadastrarAeroporto(AeroportoDTO aeroportoDto) {
        Aeroporto aeroporto = new Aeroporto();

        //busca cidade
        Cidade cidade = cidadeRepository.findById(aeroportoDto.getCidadeId()).get();

        util.copiarPropriedades(aeroportoDto, aeroporto);
        aeroporto.setCidade(cidade);
        return aeroportoRepository.save(aeroporto);
    }

    public List<AeroportoDTO> recuperarAeroportos(){
        List<Aeroporto> aeroportoList = aeroportoRepository.findAll();
        List<AeroportoDTO> aeroportoDtosResult = new ArrayList<>();
        for (Aeroporto aeroporto: aeroportoList) {
            aeroportoDtosResult.add(AeroportoDTO.convertAeroportoToDTO(aeroporto));
        }
        return aeroportoDtosResult;
    }

}
