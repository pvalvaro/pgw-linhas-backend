package pgw.linhas.areas.pgwlinhasareas.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Table(name = "TB_AEROPORTOS")
public class Aeroporto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @Column(unique = true)
    private String codigoIATA;

    @OneToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
}
