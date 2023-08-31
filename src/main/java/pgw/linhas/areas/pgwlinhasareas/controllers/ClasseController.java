package pgw.linhas.areas.pgwlinhasareas.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pgw.linhas.areas.pgwlinhasareas.dtos.CidadeDTO;
import pgw.linhas.areas.pgwlinhasareas.dtos.ClasseDTO;
import pgw.linhas.areas.pgwlinhasareas.dtos.PrecoDto;
import pgw.linhas.areas.pgwlinhasareas.models.PrecoByClasse;
import pgw.linhas.areas.pgwlinhasareas.services.ClasseService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/pwg-linhas-aereas/preco")
public class ClasseController {
    final ClasseService classeService;
    public ClasseController(ClasseService classeService) {
        this.classeService = classeService;
    }

    @PreAuthorize("hasAnyRole('ROLE_GESTOR')")
    @PostMapping
    public ResponseEntity<Object> cadastrarClasse(@RequestBody ClasseDTO classeDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(classeService.cadastrarClasse(classeDTO));
    }

    @PreAuthorize("hasAnyRole('ROLE_GESTOR', 'ROLE_USER')")
    @GetMapping
    public ResponseEntity<Object> recuperarPrecos(){
        return ResponseEntity.status(HttpStatus.OK).body(classeService.recuperarPrecos());
    }

    @PreAuthorize("hasAnyRole('ROLE_GESTOR')")
    @PutMapping("/alterar/{id}")
    public ResponseEntity<Object> alterarPreco(@PathVariable(value = "id") long id, @RequestBody ClasseDTO classeDTO){
        return ResponseEntity.status(HttpStatus.OK).body(classeService.alterarPreco(id, classeDTO));
    }
}
