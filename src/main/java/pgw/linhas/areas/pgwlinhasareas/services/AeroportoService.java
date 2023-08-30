package pgw.linhas.areas.pgwlinhasareas.services;

import pgw.linhas.areas.pgwlinhasareas.dtos.AeroportoDTO;
import pgw.linhas.areas.pgwlinhasareas.models.Aeroporto;

import java.util.List;

public interface AeroportoService {
    Aeroporto cadastrarAeroporto(AeroportoDTO aeroportoDto);
    List<AeroportoDTO> recuperarAeroportos();
}
