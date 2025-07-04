package org.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* org.library.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[AOP] BEFORE: Method " + joinPoint.getSignature().getName() + " is about to execute.");
    }

    @After("execution(* org.library.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[AOP] AFTER: Method " + joinPoint.getSignature().getName() + " has finished executing.");
    }
}
