package pgw.linhas.areas.pgwlinhasareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pgw.linhas.areas.pgwlinhasareas.models.Voo;

import java.util.List;
import java.util.Optional;

public interface VooRepository extends JpaRepository<Voo, Long> {
    @Query(value = "SELECT * FROM TB_VOOS voo WHERE voo.CODIGO_AVIAO = :codigo", nativeQuery = true)
    List<Voo> findByCodigoAviao(@Param("codigo") String codigo);
}
