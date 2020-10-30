package com.azimo.tukan.logging.micrometer;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

    @Pointcut("execution(public * com.azimo..*(..))")
    public void onToStringMethod() {}

    @Around("within(@com.azimo.tukan.logging.micrometer.SanitizedToString *)")
    public Object sanitizedToString(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("przed xxxxxxx\n");
        //AnnotationUtils.
//        addAnnotation(CrudTestResource.class, createAnnotationFromMap(RestController.class, Collections.emptyMap()));
//        addAnnotation(CrudTestResource.class, createAnnotationFromMap(RequestMapping.class, Collections.singletonMap("value", "/tests")));


        Object proceed = joinPoint.proceed();



        System.out.println("po xxxxx\n");

        return null;
    }
}
