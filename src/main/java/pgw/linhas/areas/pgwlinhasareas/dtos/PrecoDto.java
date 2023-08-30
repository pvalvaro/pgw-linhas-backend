package pgw.linhas.areas.pgwlinhasareas.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PrecoDto {
    private long classeId;
    @NotBlank
    @Size(max = 30)
    private String classeNome;
    private float valorAssento;
    private Integer qtdAssentos;

    public long getClasseId() {
        return classeId;
    }

    public void setClasseId(long classeId) {
        this.classeId = classeId;
    }

    public String getClasseNome() {
        return classeNome;
    }

    public void setClasseNome(String classeNome) {
        this.classeNome = classeNome;
    }

    public float getValorAssento() {
        return valorAssento;
    }

    public void setValorAssento(float valorAssento) {
        this.valorAssento = valorAssento;
    }

    public Integer getQtdAssentos() {
        return qtdAssentos;
    }

    public void setQtdAssentos(Integer qtdAssentos) {
        this.qtdAssentos = qtdAssentos;
    }
}
