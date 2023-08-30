package pgw.linhas.areas.pgwlinhasareas.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import pgw.linhas.areas.pgwlinhasareas.dtos.CompraPassagemDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Visitante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
}
