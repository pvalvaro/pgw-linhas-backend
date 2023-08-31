package pgw.linhas.areas.pgwlinhasareas.services.impl;

import pgw.linhas.areas.pgwlinhasareas.repositories.UsuarioRepository;
import pgw.linhas.areas.pgwlinhasareas.services.UsuarioService;

public class GestorServiceImpl implements UsuarioService {
    private final UsuarioRepository gestorRepository;
    public GestorServiceImpl(UsuarioRepository gestorRepository) {
        this.gestorRepository = gestorRepository;
    }
}
