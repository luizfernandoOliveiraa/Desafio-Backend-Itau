package com.dev.desafiobackenditau.estatistica;

import com.dev.desafiobackenditau.transacoes.TransacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private final EstatisticaProperties estatisticaProperties;
    private final TransacaoRepository transacaoRepository;

    public EstatisticaController(EstatisticaProperties estatisticaProperties, TransacaoRepository transacaoRepository) {
        this.estatisticaProperties = estatisticaProperties;
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping()
    public ResponseEntity<?> estatistica() {

        final var horaInicial = OffsetDateTime
                .now()
                .minusSeconds(estatisticaProperties.segundos());

        final var estatistica = transacaoRepository.estatistica(horaInicial);

        return ResponseEntity.status(HttpStatus.OK).body(estatistica);
    }
}
