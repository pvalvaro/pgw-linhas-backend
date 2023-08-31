package pgw.linhas.areas.pgwlinhasareas.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pgw.linhas.areas.pgwlinhasareas.dtos.AeroportoDTO;
import pgw.linhas.areas.pgwlinhasareas.services.AeroportoService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pwg-linhas-aereas/aeroportos")
public class AeroportoController {
    final AeroportoService aeroportoService;

    public AeroportoController(AeroportoService aeroportoService) {
        this.aeroportoService = aeroportoService;
    }

    @PreAuthorize("hasAnyRole('ROLE_GESTOR')")
    @PostMapping
    public ResponseEntity<Object> cadastrarAeroporto(@RequestBody AeroportoDTO aeroportoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(aeroportoService.cadastrarAeroporto(aeroportoDTO));
    }

    @PreAuthorize("hasAnyRole('ROLE_GESTOR', 'ROLE_USER')")
    @GetMapping
    public ResponseEntity<List<AeroportoDTO>> recuperarAeroportos(){
        return ResponseEntity.status(HttpStatus.OK).body(aeroportoService.recuperarAeroportos());
    }
}
