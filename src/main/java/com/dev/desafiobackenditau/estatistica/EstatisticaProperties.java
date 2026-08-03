package com.dev.desafiobackenditau.estatistica;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "estatistica")
public record EstatisticaProperties(Integer segundos) {

}
