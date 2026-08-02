package com.dev.desafiobackenditau;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransacaoRequest(BigDecimal valor, OffsetDateTime dataHora) {

}
