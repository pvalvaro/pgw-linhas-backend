package pgw.linhas.areas.pgwlinhasareas.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<Object> cadastrarVoo(@RequestBody VooDto dto){
       /* if(dto.getOrigem().equals(dto.getDestino())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Voo não pode ter a mesma origem e destino");
        }
        if(dto.getEconomica().isEmpty() || dto.getExecutiva().isEmpty() || dto.getPrimeira().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Voo sem nenhuma classe");
        }
        if(VooDto.somaAssentos(dto) == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Soma dos Assentos por classe é maior que o suportado pelo voo!");
        }*/
        return ResponseEntity.status(HttpStatus.CREATED).body(vooService.cadastrarVoos(dto));
    }

    @GetMapping("/voos")
    public ResponseEntity<List<VooDto>> pesquisarVoos(
            @RequestParam String origem,
            @RequestParam String destino,
            @RequestParam String dataPartida){
        return ResponseEntity.status(HttpStatus.OK).body(vooService.recuperarVoos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> recuperarVoo(@PathVariable(value = "id") long id){
        Optional<Voo> vooOptional = vooService.findById(id);
        if(!vooOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Voo não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vooOptional.get());
    }

    //altera voo
    @PutMapping("/{id}")
    public ResponseEntity<Object> alterarVoo(@PathVariable(value = "id") long id, @RequestBody @Valid VooDto vooDto){
        Optional<Voo> vooOptional = vooService.findById(id);
        if(!vooOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Voo não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vooService.alterarVoo(vooDto, vooOptional));
    }
/*
    @PatchMapping("/cancelar/{id}")
    public ResponseEntity<Object> cancelarVoo(@PathVariable(value = "id") long id, @RequestBody VooDto vooDto){
        vooDto.setStatus("Cancelado");
        return ResponseEntity.status(HttpStatus.OK).body(vooService.cancelar(vooDto));
    }*/
}
