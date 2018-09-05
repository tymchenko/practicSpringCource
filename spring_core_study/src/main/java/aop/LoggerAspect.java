package aop;

import logger.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggerAspect {
    @After("execution(public void info(String))")
    public void info(JoinPoint joinPoint){
        Logger logger = (Logger)joinPoint.getThis();
        if(logger.getInfo() != null) {
            String message = logger.getInfo().toString();
            System.out.print(message);
            logger.save();
        }
    }

    @After("execution(public void warn(String))")
    public void warn(JoinPoint joinPoint){
        Logger logger = (Logger)joinPoint.getThis();
        if(logger.getWarning() != null) {
            String message = logger.getWarning().toString();
            System.out.print(message);
            logger.save();
        }
    }

    @After("execution(public void error(String))")
    public void error(JoinPoint joinPoint){
        Logger logger = (Logger)joinPoint.getThis();
        if(logger.getWarning() != null) {
            String message = logger.getError().toString();
            System.out.print(message);
            logger.save();
        }
    }

    @AfterThrowing("within(logger.Logger)")
    public void infoThrow(JoinPoint joinPoint){
        System.out.println("###" + joinPoint.toString());
        Logger logger = (Logger)joinPoint.getThis();
        logger.error(joinPoint.toString());
//        if(logger.getInfo() != null) {
//            String message = logger.getInfo().toString();
//            System.out.print(message);
//            logger.save();
//        }
    }
}
