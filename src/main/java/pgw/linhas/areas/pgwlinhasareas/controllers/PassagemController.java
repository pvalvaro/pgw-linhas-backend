package pgw.linhas.areas.pgwlinhasareas.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pgw.linhas.areas.pgwlinhasareas.dtos.CompraPassagemDTO;
import pgw.linhas.areas.pgwlinhasareas.dtos.VoucherDTO;
import pgw.linhas.areas.pgwlinhasareas.models.Passageiro;
import pgw.linhas.areas.pgwlinhasareas.services.PassageiroService;
import pgw.linhas.areas.pgwlinhasareas.services.PassagemService;
import pgw.linhas.areas.pgwlinhasareas.services.VooService;

import java.util.List;

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

    @GetMapping("/calcular-passagem")
    public ResponseEntity<CompraPassagemDTO> calcularValoresPassagem(@RequestBody CompraPassagemDTO compraPassagemDTO){
        return ResponseEntity.status(HttpStatus.OK).body(passagemService.calculo(compraPassagemDTO));
    }
    @PostMapping
    public ResponseEntity<Object> comprarPassagem(@RequestBody CompraPassagemDTO compraPassagemDTO) {
        List<Passageiro> passageiroList =  passageiroService.cadastrarPassageiro(compraPassagemDTO.getPassageiros());
        compraPassagemDTO.setPassageiros(passageiroList);
        return ResponseEntity.status(HttpStatus.CREATED).body(passagemService.comprarPassagem(compraPassagemDTO));
    }

    @GetMapping("/emitir-voucher/{passagemId}")
    public ResponseEntity<VoucherDTO> emitirVoucher(@PathVariable Long passagemId) {
        // Chame o serviço para emitir voucher e retorne o voucher
        VoucherDTO voucherDTO = new VoucherDTO();
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
/*
    @PatchMapping("/cancelar/{id}")
    public ResponseEntity<Object> cancelarCompra(@PathVariable(value = "id") long id, @RequestBody PassagemDto passagemDto){
        Optional<Passagem> optionalPassagem = passagemService.findById(id);
        if(!optionalPassagem.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Passagem não encontrada");
        }
        if(optionalPassagem.isPresent() && optionalPassagem.get().getStatusPassagem().equals("Cancelada")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Passagem já está cancelado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(passagemService.cancelar(passagemDto, optionalPassagem));
    }*/
}
