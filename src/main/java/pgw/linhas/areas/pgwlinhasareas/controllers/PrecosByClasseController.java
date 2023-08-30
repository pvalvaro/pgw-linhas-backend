package pgw.linhas.areas.pgwlinhasareas.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pgw.linhas.areas.pgwlinhasareas.dtos.PrecoDto;
import pgw.linhas.areas.pgwlinhasareas.models.PrecoByClasse;
import pgw.linhas.areas.pgwlinhasareas.services.PrecoByClasseService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/pwg-linhas-aereas/precos")
public class PrecosByClasseController {
    final PrecoByClasseService precoByClasseService;

    public PrecosByClasseController(PrecoByClasseService precoByClasseService) {
        this.precoByClasseService = precoByClasseService;
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarPrecos(@RequestBody @Valid PrecoDto precoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(precoByClasseService.cadastrarPrecos(precoDto));
    }

    @GetMapping
    public ResponseEntity<List<PrecoByClasse>> recuperarPrecos(){
        return ResponseEntity.status(HttpStatus.OK).body(precoByClasseService.recuperarPrecos());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Object> alterarPreco(@PathVariable(value = "id") long id, @RequestBody @Valid PrecoDto precoDto){
        return ResponseEntity.status(HttpStatus.OK).body(precoByClasseService.alterarPreco(id, precoDto));
    }
}
