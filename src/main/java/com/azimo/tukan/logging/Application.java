package com.azimo.tukan.logging;

import com.azimo.tukan.log.sanitizer.EnableAzimoLoggingSanitizerConfiguration;
import com.azimo.tukan.log.structure.AzimoLogger;
import com.azimo.tukan.log.structure.AzimoLoggerFactory;
import com.azimo.tukan.log.structure.model.HttpRequest;
import com.azimo.tukan.log.structure.model.ProcessDetails;
import com.azimo.tukan.logging.example.ComplexObjectOne;
import com.azimo.tukan.logging.example.ComplextObjectTwo;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static net.logstash.logback.argument.StructuredArguments.f;
import static net.logstash.logback.argument.StructuredArguments.kv;

@SpringBootApplication
@EnableAzimoLoggingSanitizerConfiguration
public class Application {

    private AzimoLogger log = AzimoLoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder().bannerMode(Banner.Mode.OFF).sources(Application.class).run(args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            ComplextObjectTwo complextObjectTwo = ComplextObjectTwo.builder().value1("some_value_one").value3("some_value_three").build();
            ComplexObjectOne complexObjectOne = new ComplexObjectOne("some_value1", "some_value2", "some_value3", "some_value4", List.of("subject1", "subject2", "subject3"), complextObjectTwo);

            log.critical("ComplexObjectOne 1 {}", kv("complexObjectOne", complexObjectOne));
            log.error("ComplexObjectOne 2", kv("complexObjectOne", complexObjectOne));
            log.warn("ComplexObjectOne 3 {}", complexObjectOne.toString());
            log.critical("ComplexObjectOne 4", f(complexObjectOne), new IllegalArgumentException("some exception") );
            log.atError().withHttpRequest(HttpRequest.builder().path("localhost/some_url").build()).log("Fragile 5", kv("complexObjectOne", complexObjectOne));

            log.critical("Exception 1", f(complexObjectOne), new IllegalArgumentException("some_exception") );
            log.atWarning().withCause(new IllegalArgumentException("some msg")).log("Exception 2");
            log.atWarning().withHttpRequest(HttpRequest.builder().body("some_body").path("some_path").build()).log("Request 1");

            log.put("common_key", "common_value");
            log.warn("Process 1", ProcessDetails.builder().payerId("1").paymentId("1234").transactionMtn("WGJASK").build());
            log.atCritical().withProcessDetails(ProcessDetails.builder().payerId("1").paymentId("1234").transactionMtn("WGJASK").build()).log("Process 2");
            log.atWarning().withCause(new IllegalArgumentException("some_exception")).log("Exception with process details 1");
        };
    }
}
