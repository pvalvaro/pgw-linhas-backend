package pgw.linhas.areas.pgwlinhasareas.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pgw.linhas.areas.pgwlinhasareas.configs.security.UserDetailsServiceImpl;
import pgw.linhas.areas.pgwlinhasareas.dtos.AcessoDTO;

@RestController
@RequestMapping("/pwg-linhas-aereas/usuario")
public class AutenticacaoController {
    final UserDetailsServiceImpl userDetailsService;
    public AutenticacaoController(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PreAuthorize("hasAnyRole('ROLE_GESTOR', 'ROLE_USER')")
    @PostMapping
    public ResponseEntity<Object> cadastrarNovoUsuario(@RequestBody AcessoDTO acessoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(userDetailsService.criarUsuario(acessoDTO));
    }
}
