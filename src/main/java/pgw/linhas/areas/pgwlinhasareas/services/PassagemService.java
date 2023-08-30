package pgw.linhas.areas.pgwlinhasareas.services;

import pgw.linhas.areas.pgwlinhasareas.dtos.CompraPassagemDTO;
import pgw.linhas.areas.pgwlinhasareas.dtos.PassagemDto;
import pgw.linhas.areas.pgwlinhasareas.models.Passagem;

import java.util.List;
import java.util.Optional;

public interface PassagemService {
    Optional<Passagem> findById(long id);
    List<PassagemDto> recuperarTodosPassageiros();
    List<Passagem> comprarPassagem(CompraPassagemDTO dto);
    List<PassagemDto> recuperarPassagensCPFComprador(String cpf);
    List<PassagemDto> recuperarPassagemVoo(String codigo);
    Passagem cancelar(PassagemDto passagemDto, Optional<Passagem> optional);

    CompraPassagemDTO calculo(CompraPassagemDTO dto);
}
