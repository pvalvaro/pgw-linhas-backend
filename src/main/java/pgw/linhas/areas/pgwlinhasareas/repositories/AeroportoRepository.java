package pgw.linhas.areas.pgwlinhasareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pgw.linhas.areas.pgwlinhasareas.models.Aeroporto;

public interface AeroportoRepository extends JpaRepository<Aeroporto, Long> {
}
