package pgw.linhas.areas.pgwlinhasareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pgw.linhas.areas.pgwlinhasareas.models.Cidade;
import pgw.linhas.areas.pgwlinhasareas.models.Voo;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    @Query(value = "SELECT * FROM TB_CIDADES cidade WHERE cidade.NOME = :nome", nativeQuery = true)
    Cidade findByNome(@Param("nome") String nome);
}
