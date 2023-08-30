package pgw.linhas.areas.pgwlinhasareas.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Table(name = "TB_PASSAGENS")
public class Passagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String passagemNumero;

    @ManyToOne
    @JoinColumn(name = "passageiro_id")
    private Passageiro passageiro;

    @OneToOne
    @JoinColumn(name = "tipoClasse")
    private Classe classe;

    private double totalValor;

    @OneToOne
    @JoinColumn(name = "voo_id")
    private Voo voo;

    @ManyToOne
    @JoinColumn(name = "visitante_id")
    private Visitante visitante;
}
