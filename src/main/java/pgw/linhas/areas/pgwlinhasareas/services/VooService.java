package pgw.linhas.areas.pgwlinhasareas.services;

import org.springframework.stereotype.Service;
import pgw.linhas.areas.pgwlinhasareas.dtos.CompraPassagemDTO;
import pgw.linhas.areas.pgwlinhasareas.dtos.VooDto;
import pgw.linhas.areas.pgwlinhasareas.models.Voo;

import java.util.List;
import java.util.Optional;

@Service
public interface VooService {
    Voo cadastrarVoos(VooDto vooDto);
    Voo alterarVoo(VooDto vooDto, Optional<Voo> vooOptional);
    List<VooDto> recuperarVoos();
    Optional<Voo> findById(long id);
    Voo cancelar(VooDto vooDto);
}
