package com.azimo.tukan.logging.micrometer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.stream.Stream;

import static org.apache.logging.log4j.util.Strings.EMPTY;

@Aspect
public class LoggingAspect {

    @Around("@annotation(com.azimo.tukan.logging.micrometer.SanitizedToString)")
    public Object sanitizedToStringByAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("przed xxxxxxx\n");

        Object proceed = joinPoint.proceed();

        System.out.println("po xxxxx\n");

        return null;
    }

    @Around("within(@com.azimo.tukan.logging.micrometer.SanitizedToString *)")
    public Object sanitizedToString(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("przed xxxxxxx\n");

        Object proceed = joinPoint.proceed();

        System.out.println("po xxxxx\n");

        return null;
    }

    private String extractRequestBody(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int index = 0; index < parameterAnnotations.length; ++index) {
            Annotation[] parameterAnnotation = parameterAnnotations[index];

            boolean isRequestBody = Stream.of(parameterAnnotation)
                    .anyMatch(x -> x instanceof Sanitize);

            if (isRequestBody) {
                Object arg = joinPoint.getArgs()[index];
                return arg.toString();
            }
        }
        return EMPTY;
    }
}
