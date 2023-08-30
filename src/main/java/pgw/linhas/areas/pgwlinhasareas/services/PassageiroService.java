package pgw.linhas.areas.pgwlinhasareas.services;

import org.springframework.stereotype.Service;
import pgw.linhas.areas.pgwlinhasareas.dtos.CompraPassagemDTO;
import pgw.linhas.areas.pgwlinhasareas.models.Passageiro;

import java.util.List;

@Service
public interface PassageiroService {
    List<Passageiro> cadastrarPassageiro(List<Passageiro> passageiros);
}
