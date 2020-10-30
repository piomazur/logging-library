package com.azimo.tukan.logging.micrometer;

public class SanitizeService {

    @SanitizedToString
    public FragileInner sanitize() {
        return FragileInner.builder()
                .exposableOne("bla")
                .fragileOne("password")
                .build();
    }
}
