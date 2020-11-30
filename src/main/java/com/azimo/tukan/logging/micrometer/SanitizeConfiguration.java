package com.azimo.tukan.logging.micrometer;

import com.azimo.pio.sanitizer.core.counter.SanitizeAspect;
import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class SanitizeConfiguration {

    @Bean
    public SanitizeAspect sanitizeAspect() {
        SanitizeAspect sanitizeAspect = Aspects.aspectOf(SanitizeAspect.class);
        return sanitizeAspect;
    }
}
