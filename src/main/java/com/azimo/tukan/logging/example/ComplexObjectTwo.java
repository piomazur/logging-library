package com.azimo.tukan.logging.example;

import com.azimo.tukan.log.sanitizer.core.Sanitize;
import com.azimo.tukan.log.sanitizer.core.Sanitized;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Sanitized
public class ComplexObjectTwo {

    @Sanitize
    private String value1;
    @Sanitize
    private String value2;

    private String value3;
    private String value4;
}
