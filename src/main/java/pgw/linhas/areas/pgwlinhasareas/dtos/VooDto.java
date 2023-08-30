package pgw.linhas.areas.pgwlinhasareas.dtos;

import lombok.Data;
import org.springframework.beans.BeanUtils;
import pgw.linhas.areas.pgwlinhasareas.models.Classe;
import pgw.linhas.areas.pgwlinhasareas.models.Voo;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class VooDto {
    private Long id;
    private String numeroVoo;
    private LocalDateTime dataHoraPartida;
    private Long origem_id;
    private Long destino_id;
    private Integer totalAssentos;

    public static VooDto convertVooToDTO(Voo voo){
        VooDto vooDto = new VooDto();
        BeanUtils.copyProperties(voo, vooDto);
        return  vooDto;
    }

   /* public static Integer somaAssentos(VooDto dto){
        Integer somaAssentosClasse = dto.qtdAssentoEconomica + dto.qtdAssentoExecutiva + dto.qtdAssentoPrimeira;
        if(somaAssentosClasse > dto.totalAssentos)
            return 0;
        return 1;
    }*/
}
