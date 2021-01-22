package com.azimo.tukan.logging.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComplextObjectTwo {

    private String value1;
    private String value2;

    private String value3;
    private String value4;
}
