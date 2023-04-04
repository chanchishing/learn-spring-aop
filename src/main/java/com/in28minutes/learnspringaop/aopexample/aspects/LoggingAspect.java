package com.in28minutes.learnspringaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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

    @AfterThrowing(
            pointcut = "execution(* com.in28minutes.learnspringaop.aopexample.*.*.*(..))",
            throwing="exception"
    )
    public void logMethodCallAfterException(JoinPoint joinPoint,Exception exception) {
        logger.info("AfterThrowing Aspect - {} has thrown an exception {}", joinPoint,exception);
    }

    @AfterReturning(
            pointcut = "execution(* com.in28minutes.learnspringaop.aopexample.*.*.*(..))",
            returning="resultValue"
    )
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint,Object resultValue) {
        logger.info("AfterReturning Aspect - {} has returned {}", joinPoint,resultValue);
    }


}
