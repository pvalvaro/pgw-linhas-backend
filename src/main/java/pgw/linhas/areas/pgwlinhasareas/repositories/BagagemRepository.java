package pgw.linhas.areas.pgwlinhasareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pgw.linhas.areas.pgwlinhasareas.models.Bagagem;

public interface BagagemRepository extends JpaRepository<Bagagem, Long> {
    // Métodos personalizados, se necessário
}
