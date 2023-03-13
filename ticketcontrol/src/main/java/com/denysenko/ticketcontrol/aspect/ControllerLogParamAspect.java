package com.denysenko.ticketcontrol.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ControllerLogParamAspect {

    @Before("@annotation(com.denysenko.ticketcontrol.annotation.LogInfoControllerParam)")
    public void logControllerParameters(JoinPoint joinPoint) {
        log.info("{}, {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

}
