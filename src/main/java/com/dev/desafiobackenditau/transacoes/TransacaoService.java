package com.dev.desafiobackenditau.transacoes;

import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    public void validarTransacao(@NonNull TransacaoRequest transacaoRequest) {

        if (transacaoRequest.valor() == null || transacaoRequest.dataHora() == null) {
            throw new IllegalArgumentException("Erro: Request inválida");
        }

        if (transacaoRequest.valor().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Erro: O valor da transação não pode ser negativo");
        }

        if (transacaoRequest.dataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Erro: A data e hora da transação não podem ser no futuro");
        }
    }
}
