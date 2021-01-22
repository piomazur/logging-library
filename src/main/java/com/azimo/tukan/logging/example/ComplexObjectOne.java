package com.azimo.tukan.logging.example;

import com.azimo.tukan.log.sanitizer.core.Sanitize;
import com.azimo.tukan.log.sanitizer.core.Sanitized;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Sanitized
public class ComplexObjectOne {

    @Sanitize
    private String valueOne;
    @Sanitize
    private String valueTwo;

    private String valueThree;
    private String valueFour;

    private List<String> context;

    private ComplexObjectTwo complexObjectTwo;
}



