package pgw.linhas.areas.pgwlinhasareas.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pgw.linhas.areas.pgwlinhasareas.dtos.CidadeDTO;
import pgw.linhas.areas.pgwlinhasareas.services.CidadeService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/pwg-linhas-aereas/cidade")
public class CidadeController {
    private final CidadeService cidadeService;
      public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @PreAuthorize("hasAnyAuthority('ROLE_GESTOR')")
    @PostMapping("cadastrar")
    public ResponseEntity<Object> cadastrarClasse(@RequestBody CidadeDTO cidadeDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeService.cadastrarCidade(cidadeDTO));
    }

    @PreAuthorize("hasAnyRole('ROLE_GESTOR', 'ROLE_USER')")
    @GetMapping("/todas")
    public ResponseEntity<Object> recuperarTodasCidades(){
          return ResponseEntity.status(HttpStatus.OK).body(cidadeService.recuperarTodasCidades());
    }
}
