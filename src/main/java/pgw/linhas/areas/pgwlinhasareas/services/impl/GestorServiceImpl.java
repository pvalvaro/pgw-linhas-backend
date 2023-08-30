package pgw.linhas.areas.pgwlinhasareas.services.impl;

import pgw.linhas.areas.pgwlinhasareas.repositories.GestorRepository;
import pgw.linhas.areas.pgwlinhasareas.services.GestorService;

public class GestorServiceImpl implements GestorService {
    private final GestorRepository gestorRepository;
    public GestorServiceImpl(GestorRepository gestorRepository) {
        this.gestorRepository = gestorRepository;
    }
}
