package pgw.linhas.areas.pgwlinhasareas.models;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "TB_BAGAGENS")
public class Bagagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String numeroBagagem;

    @ManyToOne
    @JoinColumn(name = "passagem_id")
    private Passagem passagem;

    private String nomePassageiro;
}
