package pgw.linhas.areas.pgwlinhasareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pgw.linhas.areas.pgwlinhasareas.models.Passagem;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public interface PassagemRepository extends JpaRepository<Passagem, Long> {
    @Query(value = "SELECT * FROM TB_PASSAGENS ps WHERE  ps.CPF_COMPRADOR = :cpfComprador", nativeQuery = true)
    List<Passagem> recuperarPassagensCPFComprador(String cpfComprador);

    @Query(value = "SELECT * FROM TB_PASSAGENS ps WHERE  ps.CODIGO_VOO = :codigo", nativeQuery = true)
    List<Passagem> recuperarPassagemVoo(String codigo);

}
