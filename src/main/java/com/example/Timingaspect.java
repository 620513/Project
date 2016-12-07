package com.example;

/**
 * Created by ThelmaAndrews on 12/4/16.
 */


        import org.aspectj.lang.ProceedingJoinPoint;
        import org.aspectj.lang.annotation.Around;
        import org.aspectj.lang.annotation.Aspect;
        import org.aspectj.lang.annotation.Pointcut;
        import org.springframework.stereotype.Component;

@Component
@Aspect
public class Timingaspect {
    @Pointcut("execution(* com.example.Project.*(..))")
    public void allVechicleControllerMethods(){}

    @Around ("allVechicleControllerMethods() && @annotation(Timed)")
    public Object aroundAllMethods(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        final long methodstarttime=System.currentTimeMillis();
        try{
            final Object value=proceedingJoinPoint.proceed();
            return value;
        }catch(Throwable throwable){
            throw throwable;
        }finally{
            final long methodstoptime=System.currentTimeMillis();
            System.out.println("+++ Excustion Time of "+proceedingJoinPoint.getSignature().getName()+" was : "+(methodstoptime-methodstarttime));
        }
    }
}
