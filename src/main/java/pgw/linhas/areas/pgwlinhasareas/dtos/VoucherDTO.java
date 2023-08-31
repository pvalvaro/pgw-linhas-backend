package pgw.linhas.areas.pgwlinhasareas.dtos;

import lombok.Data;
import pgw.linhas.areas.pgwlinhasareas.models.Passageiro;

@Data
public class VoucherDTO {
    private String numeroPassagem;
    private String numeroVoo;
    private String origem;
    private String destino;
    private Passageiro passageiro;
    private String bagagem;
}