package pgw.linhas.areas.pgwlinhasareas.services.impl;

import pgw.linhas.areas.pgwlinhasareas.repositories.VisitanteRepository;

public class VisitanteServiceImpl {
    private final VisitanteRepository visitanteRepository;

    public VisitanteServiceImpl(VisitanteRepository visitanteRepository) {
        this.visitanteRepository = visitanteRepository;
    }
}
