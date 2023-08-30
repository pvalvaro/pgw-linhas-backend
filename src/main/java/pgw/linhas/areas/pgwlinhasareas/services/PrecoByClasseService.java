package pgw.linhas.areas.pgwlinhasareas.services;

import pgw.linhas.areas.pgwlinhasareas.dtos.PrecoDto;
import pgw.linhas.areas.pgwlinhasareas.dtos.VooDto;
import pgw.linhas.areas.pgwlinhasareas.models.PrecoByClasse;
import pgw.linhas.areas.pgwlinhasareas.models.Voo;

import java.util.List;
import java.util.Optional;

public interface PrecoByClasseService {
    PrecoByClasse cadastrarPrecos(PrecoDto precoDto);
    List<PrecoByClasse> recuperarPrecos();

    PrecoByClasse alterarPreco(long id, PrecoDto precoDto);
}
