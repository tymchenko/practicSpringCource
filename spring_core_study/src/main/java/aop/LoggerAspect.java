package aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggerAspect {

    @After("execution(public void info(String))")
    public void info(){
        System.out.println("@@@ INFO aspect");
    }
}
