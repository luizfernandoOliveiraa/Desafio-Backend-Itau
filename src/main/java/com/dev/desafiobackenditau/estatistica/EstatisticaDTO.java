package com.dev.desafiobackenditau.estatistica;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class EstatisticaDTO {

    private Long count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;

    public EstatisticaDTO( Long count, Double sum, Double avg, Double min, Double max) {
        this.count = count;
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
    }
}
