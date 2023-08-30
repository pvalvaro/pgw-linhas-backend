package pgw.linhas.areas.pgwlinhasareas.models;

import javax.persistence.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_CLASSES")
public class Classe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String tipoClasse;
    private int quantidadeAssentos;
    private double valorAssento;
}
