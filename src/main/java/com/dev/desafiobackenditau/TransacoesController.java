package com.dev.desafiobackenditau;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacoesController {

    private final TransacaoService transacaoService;

    public TransacoesController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<TransacaoRequest> criarTransacao(@Valid @RequestBody TransacaoRequest transacao) {
       try {
           transacaoService.validarTransacao(transacao);
           return ResponseEntity.status(HttpStatus.CREATED).build();

       } catch (IllegalArgumentException exception) {
           return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).build();
       }

    }

}
