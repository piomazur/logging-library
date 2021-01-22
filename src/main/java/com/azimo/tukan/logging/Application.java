package com.azimo.tukan.logging;

import com.azimo.tukan.logging.example.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import static net.logstash.logback.argument.StructuredArguments.kv;

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder().bannerMode(Banner.Mode.OFF).sources(Application.class).run(args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            User user = new User("John", "Doe", "password");

            log.warn("User {}", kv("user", user));
            log.warn("User", kv("user", user));
            log.warn("User {}", user.toString());
        };
    }
}
