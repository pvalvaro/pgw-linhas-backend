package pgw.linhas.areas.pgwlinhasareas.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pgw.linhas.areas.pgwlinhasareas.models.Passageiro;
import pgw.linhas.areas.pgwlinhasareas.models.Passagem;
import pgw.linhas.areas.pgwlinhasareas.repositories.PassageiroRepository;
import pgw.linhas.areas.pgwlinhasareas.services.PassageiroService;

import java.util.List;

@Service
public class PassageiroServiceImpl implements PassageiroService {
    private final PassageiroRepository passageiroRepository;
    public PassageiroServiceImpl(PassageiroRepository passageiroRepository) {
        this.passageiroRepository = passageiroRepository;
    }

    @Override
    public List<Passageiro> cadastrarPassageiro(List<Passageiro> passageiros) {
        return passageiroRepository.saveAll(passageiros);
    }
}
