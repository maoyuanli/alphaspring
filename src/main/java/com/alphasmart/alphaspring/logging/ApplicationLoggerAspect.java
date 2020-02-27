package com.alphasmart.alphaspring.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ApplicationLoggerAspect {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Pointcut("within(com.alphasmart.alphaspring.components..*)")
    public void componentPoincut(){}

    @Before("componentPoincut()")
    public void logComponentBefore(JoinPoint joinPoint){
        LOGGER.debug(String.format("-*-*-*-*-*-*-*-*-*-*-* Before Component [ %s ] Run *-*-*-*-*-*-*-*-*-*-*-*-*-",joinPoint.getSignature().getDeclaringTypeName()));
    }

    @After("componentPoincut()")
    public void logComponentAfter(JoinPoint joinPoint){
        LOGGER.debug(String.format("-*-*-*-*-*-*-*-*-*-*-* After Component [ %s ] Run *-*-*-*-*-*-*-*-*-*-*-*-*-",joinPoint.getSignature().getDeclaringTypeName()));
    }

    @Pointcut("within(com.alphasmart.alphaspring.services..*)")
    public void servicePoincut(){}

    @Before("servicePoincut()")
    public void logServiceBefore(JoinPoint joinPoint){
        LOGGER.debug(String.format("-*-*-*-*-*-*-*-*-*-*-* Before Service [ %s ] Run *-*-*-*-*-*-*-*-*-*-*-*-*-",joinPoint.getSignature().getDeclaringTypeName()));
    }

    @After("servicePoincut()")
    public void logServiceAfter(JoinPoint joinPoint){
        LOGGER.debug(String.format("-*-*-*-*-*-*-*-*-*-*-* After Service [ %s ] Run *-*-*-*-*-*-*-*-*-*-*-*-*-",joinPoint.getSignature().getDeclaringTypeName()));
    }
}
