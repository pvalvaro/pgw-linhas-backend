package pgw.linhas.areas.pgwlinhasareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pgw.linhas.areas.pgwlinhasareas.models.Passagem;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public interface PassagemRepository extends JpaRepository<Passagem, Long> {
    @Query(value = "SELECT * FROM TB_PASSAGENS ps WHERE  ps.CPF_COMPRADOR = :cpfComprador", nativeQuery = true)
    List<Passagem> recuperarPassagensCPFComprador(String cpfComprador);

    @Query(value = "SELECT * FROM TB_PASSAGENS ps WHERE  ps.CODIGO_VOO = :codigo", nativeQuery = true)
    List<Passagem> recuperarPassagemVoo(String codigo);
/*
    @Query(nativeQuery = true,
            value = "SELECT p.passagem_numero, pa.*, v." +
                    "FROM TB_PASSAGENS p " +
                    "INNER JOIN Passageiro pa ON p.idPassageiro = pa.idPassageiro " +
                    "INNER JOIN Voo v ON p.idVoo = v.idVoo ")
    Passagem findByNumeroPassagem(String numeroPassagem);*/
}
