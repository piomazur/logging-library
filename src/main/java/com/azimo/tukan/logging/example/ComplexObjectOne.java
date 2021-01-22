package com.azimo.tukan.logging.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ComplexObjectOne {

    @JsonProperty
    private String valueOne;
    private String valueTwo;

    private String valueThree;
    private String valueFour;

    private List<String> context;

    private ComplextObjectTwo complextObjectTwo;
}



