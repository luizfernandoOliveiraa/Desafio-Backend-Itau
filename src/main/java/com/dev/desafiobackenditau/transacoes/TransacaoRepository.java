package com.dev.desafiobackenditau.transacoes;

import com.dev.desafiobackenditau.estatistica.EstatisticaDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    @Value("${estatistica.segundos:60}")
    private Long janelaEmSegundos;

    List<TransacaoRequest> listaDeTransacoes = new ArrayList<>();

    public void salvarDados(TransacaoRequest transacaoRequest) {
        listaDeTransacoes.add(transacaoRequest);
    }

    public void limparDados60Segundos(){
        OffsetDateTime limiteTempo = OffsetDateTime.now().minusSeconds(janelaEmSegundos);
        listaDeTransacoes.removeIf(t -> t.dataHora().isBefore(limiteTempo));
    }

    public void deletarDados(){
        listaDeTransacoes.clear();
    }

    public EstatisticaDTO estatistica(OffsetDateTime horaInicial) {

        OffsetDateTime limiteTempo = OffsetDateTime.now().minusSeconds(janelaEmSegundos);

        final var transacoes = listaDeTransacoes.stream()
                .filter(t -> t.dataHora().isAfter(limiteTempo))
                .toList();

        if (transacoes.isEmpty()) {
            return new EstatisticaDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }

        final var summary = listaDeTransacoes.stream()
                .filter(t ->
                        t.dataHora().isAfter(horaInicial) || t.dataHora().isEqual(horaInicial)
                        )
                .mapToDouble(t -> t.valor().doubleValue())
                .summaryStatistics();

        return new EstatisticaDTO(
                summary.getCount(),
                summary.getSum(),
                summary.getAverage(),
                summary.getMin(),
                summary.getMax()
        );
    }
}
