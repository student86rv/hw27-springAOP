package ua.epam.springAOP.aspect;

import org.aspectj.lang.JoinPoint;

import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlConfiguredLoggerAspect {
    private static Logger logger = Logger.getLogger(XmlConfiguredLoggerAspect.class.getName());

    public void logBefore(JoinPoint joinPoint) {
        logger.log(Level.INFO, "Method " + joinPoint.getSignature().getName() + " has been called!");
    }

    public void logAfter(JoinPoint joinPoint) {
        logger.log(Level.INFO, "Method " + joinPoint.getSignature().getName() + " has been executed!");
    }
}
