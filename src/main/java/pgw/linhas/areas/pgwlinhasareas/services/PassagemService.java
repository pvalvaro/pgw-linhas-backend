package pgw.linhas.areas.pgwlinhasareas.services;

import pgw.linhas.areas.pgwlinhasareas.dtos.CompraPassagemDTO;
import pgw.linhas.areas.pgwlinhasareas.dtos.PassagemDto;
import pgw.linhas.areas.pgwlinhasareas.dtos.VoucherDTO;
import pgw.linhas.areas.pgwlinhasareas.models.Passagem;

import java.util.List;
import java.util.Optional;

public interface PassagemService {
    Optional<Passagem> findById(long id);
    List<Passagem> comprarPassagem(CompraPassagemDTO dto);
    List<CompraPassagemDTO> recuperarPassagensCPFComprador(String cpf);
    List<CompraPassagemDTO> recuperarPassagemVoo(String codigo);
    Passagem cancelar(Long id);
    VoucherDTO emitirVoucher(String numeroPassagem);
    CompraPassagemDTO calculo(CompraPassagemDTO dto);
}
