package com.alphasmart.alphaspring.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ApplicationLoggerAspect {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Pointcut("within(com.alphasmart.alphaspring.utils..*)")
    public void componentPoincut() {
    }

    @Before("componentPoincut()")
    public void logComponentBefore(JoinPoint joinPoint) {
        LOGGER.debug(String.format("-*-*-*-*-*-*-*-*-*-*-* Before Component [ %s ] Run *-*-*-*-*-*-*-*-*-*-*-*-*-", joinPoint.getSignature().getDeclaringTypeName()));
    }

    @After("componentPoincut()")
    public void logComponentAfter(JoinPoint joinPoint) {
        LOGGER.debug(String.format("-*-*-*-*-*-*-*-*-*-*-* After Component [ %s ] Run *-*-*-*-*-*-*-*-*-*-*-*-*-", joinPoint.getSignature().getDeclaringTypeName()));
    }

    @Pointcut("within(com.alphasmart.alphaspring.services..*)")
    public void servicePoincut() {
    }

    @Around("servicePoincut()")
    public Object logServiceAround(ProceedingJoinPoint joinPoint) throws Throwable {

        LOGGER.debug(String.format("-*-*-*-*-*-*-*-*-*-*-* Before Service [ %s ] Run *-*-*-*-*-*-*-*-*-*-*-*-*-", joinPoint.getSignature().getDeclaringTypeName()));
        Object o = joinPoint.proceed();
        LOGGER.debug(String.format("-*-*-*-*-*-*-*-*-*-*-* After Service [ %s ] Run *-*-*-*-*-*-*-*-*-*-*-*-*-", joinPoint.getSignature().getDeclaringTypeName()));

        return o;
    }
}

