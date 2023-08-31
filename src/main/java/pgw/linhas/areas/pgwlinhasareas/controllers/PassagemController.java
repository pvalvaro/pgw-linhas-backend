package pgw.linhas.areas.pgwlinhasareas.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pgw.linhas.areas.pgwlinhasareas.dtos.CompraPassagemDTO;
import pgw.linhas.areas.pgwlinhasareas.dtos.VoucherDTO;
import pgw.linhas.areas.pgwlinhasareas.models.Passageiro;
import pgw.linhas.areas.pgwlinhasareas.models.Passagem;
import pgw.linhas.areas.pgwlinhasareas.services.PassageiroService;
import pgw.linhas.areas.pgwlinhasareas.services.PassagemService;
import pgw.linhas.areas.pgwlinhasareas.services.VooService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pwg-linhas-aereas/passagem")
public class PassagemController {
    final PassagemService passagemService;
    final PassageiroService passageiroService;
    final VooService vooService;

    public PassagemController(PassagemService passagemService, PassageiroService passageiroService, VooService vooService) {
        this.passagemService = passagemService;
        this.passageiroService = passageiroService;
        this.vooService = vooService;
    }

    @PreAuthorize("hasAnyRole('ROLE_GESTOR', 'ROLE_USER')")
    @GetMapping("/calcular-passagem")
    public ResponseEntity<CompraPassagemDTO> calcularValoresPassagem(@RequestBody CompraPassagemDTO compraPassagemDTO){
        return ResponseEntity.status(HttpStatus.OK).body(passagemService.calculo(compraPassagemDTO));
    }
    @PreAuthorize("hasAnyRole('ROLE_GESTOR')")
    @PostMapping
    public ResponseEntity<Object> comprarPassagem(@RequestBody CompraPassagemDTO compraPassagemDTO) {
        List<Passageiro> passageiroList =  passageiroService.cadastrarPassageiro(compraPassagemDTO.getPassageiros());
        compraPassagemDTO.setPassageiros(passageiroList);
        return ResponseEntity.status(HttpStatus.CREATED).body(passagemService.comprarPassagem(compraPassagemDTO));
    }

    @PreAuthorize("hasAnyRole('ROLE_GESTOR')")
    @GetMapping("/codivoo/{codigo}")
    public ResponseEntity<List<CompraPassagemDTO>> recuperarPassagemVoo(@PathVariable(value ="codigo") String codigo){
        return ResponseEntity.status(HttpStatus.OK).body(passagemService.recuperarPassagemVoo(codigo));
    }

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @GetMapping("/comprador/{cpf}")
    public ResponseEntity<List<CompraPassagemDTO>> recuperarPassagensCPFComprador(@PathVariable(value ="cpf") String cpf){
        return ResponseEntity.status(HttpStatus.OK).body(passagemService.recuperarPassagensCPFComprador(cpf));
    }

    @PreAuthorize("hasAnyRole('ROLE_GESTOR')")
    @PatchMapping("/cancelar/{id}")
    public ResponseEntity<Object> cancelarCompra(@PathVariable(value = "id") long id){
        return ResponseEntity.status(HttpStatus.OK).body(passagemService.cancelar(id));
    }
    @PreAuthorize("hasAnyRole('ROLE_GESTOR', 'ROLE_USER')")
    @GetMapping("/emitir-voucher/{numeroPassagem}")
    public ResponseEntity<VoucherDTO> emitirVoucher(@PathVariable String numeroPassagem) {
        // Chame o serviço para emitir voucher e retorne o voucher
        VoucherDTO voucherDTO = passagemService.emitirVoucher(numeroPassagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(voucherDTO);
    }
/*
    @GetMapping
    public ResponseEntity<List<PassagemDto>> recuperarTodosPassageiros(){
        return ResponseEntity.status(HttpStatus.OK).body(passagemService.recuperarTodosPassageiros());
    }*/
/*
    @GetMapping("/comprador/{cpf}")
    public ResponseEntity<List<PassagemDto>> recuperarPassagensCPFComprador(@PathVariable(value ="cpf") String cpf){
        return ResponseEntity.status(HttpStatus.OK).body(passagemService.recuperarPassagensCPFComprador(cpf));
    }*/

/*
    @GetMapping("/codivoo/{codigo}")
    public ResponseEntity<List<PassagemDto>> recuperarPassagemVoo(@PathVariable(value ="codigo") String codigo){
        return ResponseEntity.status(HttpStatus.OK).body(passagemService.recuperarPassagemVoo(codigo));
    }*/
}
