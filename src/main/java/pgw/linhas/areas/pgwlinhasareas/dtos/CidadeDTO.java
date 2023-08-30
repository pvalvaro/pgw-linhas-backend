package pgw.linhas.areas.pgwlinhasareas.dtos;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CidadeDTO {
    private Long id;
    private String nome;
    private String unidadeFederativa;
}
