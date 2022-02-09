package com.myogui.ecommercejava.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AspectAfterThrowing {
    Logger logger = LogManager.getLogger(AspectAfterThrowing.class);

    @Pointcut("execution (* com.myogui.ecommercejava.service.*.*(..))")
    void afterThrowingServiceException() {}

    @AfterThrowing("afterThrowingServiceException()")
    void afterExceptionEnService(JoinPoint jp) {
        logger.info(jp.getSignature().getName() + " | " + String.valueOf(LocalDateTime.now()));
    }
}
