package pgw.linhas.areas.pgwlinhasareas.dtos;

import lombok.Data;
import pgw.linhas.areas.pgwlinhasareas.models.Classe;
import pgw.linhas.areas.pgwlinhasareas.models.Passageiro;
import pgw.linhas.areas.pgwlinhasareas.models.Visitante;
import pgw.linhas.areas.pgwlinhasareas.models.Voo;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.List;

@Data
public class CompraPassagemDTO {
    private Long id;

    private String passagemNumero;
    private double totalValor;

    private List<Passageiro> passageiros;

    private Long classeId;

    private Long vooId;

    private boolean bagagemDespachada;

    private Integer qtdBagagem;

    private double valorBagagem;

    private Voo voo;

    private Visitante visitante;

}
