package pgw.linhas.areas.pgwlinhasareas.dtos;

import lombok.Data;

@Data
public class ClasseDTO {
    private Long id;
    private String tipoClasse;
    private int quantidadeAssentos;
    private double valorAssento;
}
