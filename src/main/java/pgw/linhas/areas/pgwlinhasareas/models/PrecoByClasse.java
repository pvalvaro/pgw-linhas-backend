package pgw.linhas.areas.pgwlinhasareas.models;

import javax.persistence.*;
@Entity
@Table(name = "TB_CLASSES_PRECOS")
public class PrecoByClasse {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long classeId;
    @Column(nullable = false, length = 30)
    private String classeNome;
    @Column(nullable = false)
    private float valorAssento;
    @Column(nullable = false)
    private Integer qtdAssentos;

    public PrecoByClasse(){
    }

    public PrecoByClasse(long classeId, String classeNome, float valorAssento, Integer qtdAssentos) {
        this.classeId = classeId;
        this.classeNome = classeNome;
        this.valorAssento = valorAssento;
        this.qtdAssentos = qtdAssentos;
    }

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

    @Override
    public String toString() {
        return "Precos{" +
                "classeId=" + classeId +
                ", classeNome='" + classeNome + '\'' +
                ", valorAssento=" + valorAssento +
                ", qtdAssentos=" + qtdAssentos +
                '}';
    }
}
