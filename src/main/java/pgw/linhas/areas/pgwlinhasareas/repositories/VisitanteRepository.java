package pgw.linhas.areas.pgwlinhasareas.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import pgw.linhas.areas.pgwlinhasareas.models.Visitante;

public interface VisitanteRepository extends JpaRepository<Visitante, Long> {
    // Métodos personalizados, se necessário
}
