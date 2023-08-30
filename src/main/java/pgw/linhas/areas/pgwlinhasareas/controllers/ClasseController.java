package pgw.linhas.areas.pgwlinhasareas.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pgw.linhas.areas.pgwlinhasareas.dtos.CidadeDTO;
import pgw.linhas.areas.pgwlinhasareas.dtos.ClasseDTO;
import pgw.linhas.areas.pgwlinhasareas.services.ClasseService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/pwg-linhas-aereas/classe")
public class ClasseController {
    final ClasseService classeService;
    public ClasseController(ClasseService classeService) {
        this.classeService = classeService;
    }
    @PostMapping
    public ResponseEntity<Object> cadastrarClasse(@RequestBody ClasseDTO classeDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(classeService.cadastrarClasse(classeDTO));
    }
}
