package pgw.linhas.areas.pgwlinhasareas.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<Object> cadastrarClasse(@RequestBody CidadeDTO cidadeDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeService.cadastrarCidade(cidadeDTO));
    }

}
