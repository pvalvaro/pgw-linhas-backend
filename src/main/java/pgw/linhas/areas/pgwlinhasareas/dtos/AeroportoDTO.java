package pgw.linhas.areas.pgwlinhasareas.dtos;

import lombok.Data;
import pgw.linhas.areas.pgwlinhasareas.models.Aeroporto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AeroportoDTO {
    private Long id;
    private String nome;
    private String codigoIATA;
    private Long cidadeId;

     public static AeroportoDTO convertAeroportoToDTO(Aeroporto aeroporto){
        AeroportoDTO aeroportoDto = new AeroportoDTO();
      /*  aeroportoDto.setAeroportoNome(aeroporto.getAeroportoNome());
        aeroportoDto.setCidadeNome(aeroporto.getCidadeNome());
        aeroportoDto.setCodigoIATA(aeroporto.getCodigoIATA());
        aeroportoDto.setEstadoNome(aeroporto.getEstadoNome());*/

        return  aeroportoDto;
    }
}
