package pgw.linhas.areas.pgwlinhasareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pgw.linhas.areas.pgwlinhasareas.models.Gestor;

public interface GestorRepository extends JpaRepository<Gestor, Long> {
    // Métodos personalizados, se necessário
}