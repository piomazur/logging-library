package com.azimo.tukan.logging;

import com.azimo.tukan.logging.micrometer.EnableAzimoLoggingConfiguration;
import com.azimo.tukan.logging.micrometer.FragileInner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import static net.logstash.logback.argument.StructuredArguments.keyValue;
import static net.logstash.logback.argument.StructuredArguments.kv;

@Slf4j
@SpringBootApplication
@EnableAzimoLoggingConfiguration
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder().bannerMode(Banner.Mode.OFF).sources(Application.class).run(args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            String simpleKeyValue = "123";
            log.error("Simple key value {}", keyValue("simpleKeyValue", simpleKeyValue));

            FragileInner fragile = FragileInner.builder()
                    .fragileOne("password")
                    .fragileTwo("login")
                    .exposableOne("city")
                    .exposableTwo("some unimportant things")
                    .build();

            System.out.println(fragile);

            log.error("Complex with fragile info {}", kv("fragile", fragile));

            log.error("Fragile: {}", fragile.getExposableOne());
        };
    }
}
