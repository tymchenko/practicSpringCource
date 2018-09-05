package aop;

import logger.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.CollectionUtils;

@Aspect
public class LoggerAspect {

    @After("execution(public void info(String))")
    public void info(JoinPoint joinPoint){
        Logger logger = (Logger)joinPoint.getThis();
        if(!CollectionUtils.isEmpty(logger.getInfo())) {
            String message = logger.getInfo().get(logger.getInfo().size() - 1).toString();
            System.out.print(message);
            logger.save();
        }
    }

    @After("execution(public void warn(String))")
    public void warn(JoinPoint joinPoint){
        Logger logger = (Logger)joinPoint.getThis();
        if(!CollectionUtils.isEmpty(logger.getWarnings())) {
            System.out.print(logger.getWarnings().get(logger.getWarnings().size() - 1));
        }
    }

    @After("execution(public void error(String))")
    public void error(JoinPoint joinPoint){
        Logger logger = (Logger)joinPoint.getThis();
        if(!CollectionUtils.isEmpty(logger.getErrors())) {
            System.out.print(logger.getErrors().get(logger.getErrors().size() - 1));
        }
    }
}
