package com.myogui.ecommercejava.interceptor;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AspectAfter {
    Logger logger = LogManager.getLogger(AspectAfter.class);

    @Pointcut("execution(* com.myogui.ecommercejava.service.*.*(..))")
    void afterThrowingExceptionService(){}

    @After("afterThrowingExceptionService()")
    void afterThrowingService(JoinPoint jp) {
        String method = jp.getSignature().getName();
        logger.info(method + " | " + String.valueOf(LocalDateTime.now()));
    }
}
