package com.guillermoblasco.service.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggerAspect {

    @Around(value = "@annotation(logAnnotation)", argNames = "joinPoint,logAnnotation")
    public Object log(ProceedingJoinPoint joinPoint, Log logAnnotation) throws Throwable {
        log.info("Before");
        try {
            Object ret = joinPoint.proceed();
            log.info("After");
            return ret;
        } catch (Throwable throwable) {
            log.info("Exception");
            throw throwable;
        }
    }
}
