package pgw.linhas.areas.pgwlinhasareas.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import pgw.linhas.areas.pgwlinhasareas.enums.NomeRole;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_ROLE")
public class Role  implements GrantedAuthority, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * As informações desse atributo virão do arquivo ENUM, por isso que se usou a anotação EnumType
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private NomeRole nomeRole;

    @Override
    public String getAuthority() {
        return this.nomeRole.toString();
    }

}
