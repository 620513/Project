package com.example;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class Loggingaspect {
    @Before("execution(* com.example.Project.addVehicle(..))")
    public void beforeaddlog(final JoinPoint joinPoint){
        final long methodstarttime=System.currentTimeMillis();
        System.out.println("+++ Each time this method is called "+methodstarttime);
        System.out.println("*** Executing: "+joinPoint.getSignature());
        Object[] passingarguments= joinPoint.getArgs();
        if(passingarguments!=null && passingarguments.length!=0){
            for(Object argument : passingarguments){
                System.out.println("***"+argument.getClass().getSimpleName() + " = "+argument);
            }
        }
        System.out.println("**** arguments : " + Arrays.toString(joinPoint.getArgs()));

    }

}
