package com.azimo.tukan.logging.micrometer;

import com.azimo.pio.sanitizer.core.counter.Sanitize;
import com.azimo.pio.sanitizer.core.counter.Sanitized;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Sanitized
@AllArgsConstructor
public class FragileInner {

    @JsonProperty
    @Sanitize
    private String fragileOne;
    @Sanitize
    private String fragileTwo;

    private String exposableOne;
    private String exposableTwo;
}



