package pgw.linhas.areas.pgwlinhasareas.services.impl;

import pgw.linhas.areas.pgwlinhasareas.repositories.BagagemRepository;

public class BagagemServiceImpl {
    private final BagagemRepository bagagemRepository;

    public BagagemServiceImpl(BagagemRepository bagagemRepository) {
        this.bagagemRepository = bagagemRepository;
    }
}
