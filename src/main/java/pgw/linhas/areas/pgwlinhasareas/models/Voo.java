package pgw.linhas.areas.pgwlinhasareas.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "TB_VOOS")
public class Voo implements Serializable {
    private static final long serialVersionUID = 1L;
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String numeroVoo;
 private LocalDateTime dataHoraPartida;
 private Integer totalAssentos;

 @OneToOne
 @JoinColumn(name = "origem")
 private Aeroporto origem;

 @OneToOne
 @JoinColumn(name = "destino_id")
 private Aeroporto destino;

 @OneToOne
 @JoinColumn(name = "economica")
 private Classe economica;

 @OneToOne
 @JoinColumn(name = "primeira")
 private Classe primeira;

 @OneToOne
 @JoinColumn(name = "executiva")
 private Classe executiva;

}
