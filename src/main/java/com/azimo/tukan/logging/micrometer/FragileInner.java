package com.azimo.tukan.logging.micrometer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
@SanitizedToString
public class FragileInner {

    @JsonProperty
    @Sanitize
    private String fragileOne;
    @Sanitize
    private String fragileTwo;

    private String exposableOne;
    private String exposableTwo;

    @Override
    public String toString() {
        return "FragileInner{" +
                "fragileOne='" + fragileOne + '\'' +
                ", fragileTwo='" + fragileTwo + '\'' +
                ", exposableOne='" + exposableOne + '\'' +
                ", exposableTwo='" + exposableTwo + '\'' +
                '}';
    }
}
