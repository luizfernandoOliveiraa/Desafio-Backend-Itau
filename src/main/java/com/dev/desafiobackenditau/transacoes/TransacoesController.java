package com.dev.desafiobackenditau.transacoes;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacoesController {

    private final TransacaoService transacaoService;
    private final TransacaoRepository transacaoRepository;

    public TransacoesController(TransacaoRepository transacaoRepository, TransacaoService transacaoService) {
        this.transacaoRepository = transacaoRepository;
        this.transacaoService = transacaoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criarTransacao(@Valid @RequestBody TransacaoRequest transacao) {
       try {
           transacaoService.validarTransacao(transacao);
           transacaoRepository.salvarDados(transacao);
           return ResponseEntity.status(HttpStatus.CREATED).build();

       } catch (IllegalArgumentException exception) {
           return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).build();

       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
       }
    }

    @DeleteMapping()
    public ResponseEntity<String> deletarTransacoes() {
            transacaoRepository.deletarDados();
            return ResponseEntity.ok().body("Transações deletadas com sucesso");
    }

}
