package ua.epam.springAOP.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class CustomLoggerAspect {

    private static Logger logger = Logger.getLogger(CustomLoggerAspect.class.getName());

    @Pointcut("within(ua.epam.springAOP.service..*)")
    public void inService() {
    }

    @Pointcut("@annotation(ua.epam.springAOP.annotation.Logged)")
    public void onAnnotation() {
    }

    @Before("inService()")
    public void logBefore(JoinPoint joinPoint) {
        logger.log(Level.INFO, "Method " + joinPoint.getSignature().getName() + " has been called!");
    }

    @After("onAnnotation()")
    public void logAfter(JoinPoint joinPoint) {
        logger.log(Level.INFO, "Method " + joinPoint.getSignature().getName() + " has been executed!");
    }
}
