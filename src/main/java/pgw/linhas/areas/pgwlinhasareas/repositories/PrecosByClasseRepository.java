package pgw.linhas.areas.pgwlinhasareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pgw.linhas.areas.pgwlinhasareas.models.PrecoByClasse;

public interface PrecosByClasseRepository extends JpaRepository<PrecoByClasse, Long> {
}
