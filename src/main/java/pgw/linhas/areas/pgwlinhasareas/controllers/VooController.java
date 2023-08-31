package pgw.linhas.areas.pgwlinhasareas.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pgw.linhas.areas.pgwlinhasareas.dtos.VooDto;
import pgw.linhas.areas.pgwlinhasareas.models.Voo;
import pgw.linhas.areas.pgwlinhasareas.services.VooService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

@RequestMapping("/pwg-linhas-aereas/voo")
public class VooController {
    private final VooService vooService;

    public VooController(VooService vooService) {
        this.vooService = vooService;
    }

    @PreAuthorize("hasAnyRole('ROLE_GESTOR')")
    @PostMapping
    public ResponseEntity<Object> cadastrarVoo(@RequestBody VooDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(vooService.cadastrarVoos(dto));
    }

    @PreAuthorize("hasAnyRole('ROLE_GESTOR', 'ROLE_USER')")
    @GetMapping("/voos")
    public ResponseEntity<List<VooDto>> pesquisarVoos(
            @RequestParam String origem,
            @RequestParam String destino,
            @RequestParam String dataPartida){
        return ResponseEntity.status(HttpStatus.OK).body(vooService.recuperarVoos());
    }
    @PreAuthorize("hasAnyRole('ROLE_GESTOR', 'ROLE_USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Object> recuperarVoo(@PathVariable(value = "id") long id){
        Optional<Voo> vooOptional = vooService.findById(id);
        if(!vooOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Voo não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vooOptional.get());
    }

    //altera voo
    @PreAuthorize("hasAnyRole('ROLE_GESTOR')")
    @PutMapping("/{id}")
    public ResponseEntity<Object> alterarVoo(@PathVariable(value = "id") long id, @RequestBody @Valid VooDto vooDto){
        Optional<Voo> vooOptional = vooService.findById(id);
        if(!vooOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Voo não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vooService.alterarVoo(vooDto, vooOptional));
    }

    @PreAuthorize("hasAnyRole('ROLE_GESTOR')")
    @PatchMapping("/cancelar/{id}")
    public ResponseEntity<Object> cancelarVoo(@PathVariable(value = "id") long id, @RequestBody VooDto vooDto){
        vooDto.setStatus("Cancelado");
        return ResponseEntity.status(HttpStatus.OK).body(vooService.cancelar(vooDto));
    }
}
