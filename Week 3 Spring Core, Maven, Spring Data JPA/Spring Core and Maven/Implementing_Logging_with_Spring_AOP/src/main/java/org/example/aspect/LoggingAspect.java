package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.library..*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().toShortString();
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed(); // proceed with the actual method

        long end = System.currentTimeMillis();
        System.out.println("[LOG] Method " + method + " executed in " + (end - start) + " ms");

        return result;
    }
}