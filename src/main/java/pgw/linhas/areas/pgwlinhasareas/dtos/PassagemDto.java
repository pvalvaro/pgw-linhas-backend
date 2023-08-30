package pgw.linhas.areas.pgwlinhasareas.dtos;


import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Data
public class PassagemDto {
    private Long passagemId;

    private String localizador;

    private String passageiroNome;

    private String cpfPassageiro;
    private Date dataNascimentoPassageiro;
    private float totalViagem;

    private String classeEscolhida;

    private String origem;

    private String destino;

    private String codigoVoo;

    private String nomeComprador;

    private String emailComprador;

    private String cpfComprador;
    private Date dataCompra;
    private Integer qtdBagagemExtra;

    private String statusPassagem;
    private String identificBagagem;
    private Timestamp dataPartida;
    private Timestamp dataChegada;
    private Integer qtdPassagens;

}
