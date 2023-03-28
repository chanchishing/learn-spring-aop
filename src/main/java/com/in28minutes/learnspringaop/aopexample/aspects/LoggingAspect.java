package com.in28minutes.learnspringaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger= LoggerFactory.getLogger(getClass());

    //com.in28minutes.learnspringaop.aopexample.businese

    @Before("execution(* com.in28minutes.learnspringaop.aopexample.*.*.*(..))")
    public void logMethodCallB4(JoinPoint joinPoint) {
        logger.info("Before Aspect - {} Method is called with arguments: {}", joinPoint,joinPoint.getArgs());
    }

    @After("execution(* com.in28minutes.learnspringaop.aopexample.*.*.*(..))")
    public void logMethodCallAfter(JoinPoint joinPoint) {
        logger.info("After Aspect - {} Method has executed", joinPoint);
    }

}
