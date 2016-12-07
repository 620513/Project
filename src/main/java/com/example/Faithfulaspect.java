package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class Faithfulaspect {
    @Pointcut("execution(* com.example.Project.*(..))")
    public void allVehicleMethods() {}

    @Before("allVehicleMethods()")
    public void addLog(final JoinPoint joinPoint){
        System.out.println("*** Executing: "+joinPoint.getSignature());
        Object[] arguments= joinPoint.getArgs();
        if(arguments!=null && arguments.length!=0){
            for(Object argument : arguments){
                System.out.println("***"+argument.getClass().getSimpleName() + " = "+argument);
            }
        }
        System.out.println("**** arguments : " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("allVehicleMethods()")
    public void afterLog(final JoinPoint joinPoint){
        System.out.println("***  Executing: "+joinPoint.getSignature());
        Object[] arguments= joinPoint.getArgs();
        if(arguments!=null && arguments.length!=0){
            for(Object argument : arguments){
                System.out.println("***"+argument.getClass().getSimpleName() + " = "+argument);
            }
        }
        System.out.println("****  After arguments : " + Arrays.toString(joinPoint.getArgs()));
    }

    @Pointcut("execution(* com.example.Hotellmpl.*(..))")
    public void allProjectMethods() {}

    @Before("allProjectMethods()")
    public void addCustomerAddressLog(final JoinPoint joinPoint){
        System.out.println("*** Before Executing All CustomerAddress: "+joinPoint.getSignature());
        Object[] arguments= joinPoint.getArgs();
        if(arguments!=null && arguments.length!=0){
            for(Object argument : arguments){
                System.out.println("***"+argument.getClass().getSimpleName() + " = "+argument);
            }
        }
        System.out.println("**** Before executing all Customer arguments : " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("allProjectMethods()")
    public void afterCustomerAddressLog(final JoinPoint joinPoint){
        System.out.println("*** After Executing All CustomerAddress : "+joinPoint.getSignature());
        Object[] arguments= joinPoint.getArgs();
        if(arguments!=null && arguments.length!=0){
            for(Object argument : arguments){
                System.out.println("***"+argument.getClass().getSimpleName() + " = "+argument);
            }
        }
        System.out.println("**** After executing all CustomerAddress arguments : " + Arrays.toString(joinPoint.getArgs()));
    }

    @Pointcut("execution(* com.example.MyTasks.*(..))")
    public void allMyScheduledTasksMethods() {}

    @Before("allMyScheduledTasksMethods()")
    public void addMyTaskseLog(final JoinPoint joinPoint){
        System.out.println("*** Before Executing All my tasks: "+joinPoint.getSignature());
        Object[] arguments= joinPoint.getArgs();
        if(arguments!=null && arguments.length!=0){
            for(Object argument : arguments){
                System.out.println("***"+argument.getClass().getSimpleName() + " = "+argument);
            }
        }
        System.out.println("**** Before executing all my tasks arguments : " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("allMyScheduledTasksMethods()")
    public void afterMyTasksLog(final JoinPoint joinPoint){
        System.out.println("*** After Executing All my tasks : "+joinPoint.getSignature());
        Object[] arguments= joinPoint.getArgs();
        if(arguments!=null && arguments.length!=0){
            for(Object argument : arguments){
                System.out.println("***"+argument.getClass().getSimpleName() + " = "+argument);
            }
        }
        System.out.println("**** After executing all my tasks arguments : " + Arrays.toString(joinPoint.getArgs()));
    }

    @Pointcut("execution(* com.example.HotelSchedule.*(..))")
    public void allHotelScheduleMethods() {}

    @Before("allHotelScheduleMethods()")
    public void addAllCustomerAddressTasksMethodsLog(final JoinPoint joinPoint){
        System.out.println("*** Before Executing All Hotel tasks: "+joinPoint.getSignature());
        Object[] arguments= joinPoint.getArgs();
        if(arguments!=null && arguments.length!=0){
            for(Object argument : arguments){
                System.out.println("***"+argument.getClass().getSimpleName() + " = "+argument);
            }
        }
        System.out.println("**** Before executing all Detailed tasks arguments : " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("allHotelScheduleMethods()")
    public void afterAllCustomerAddressTasksMethodsLog(final JoinPoint joinPoint){
        System.out.println("*** After Executing All Hotel tasks : "+joinPoint.getSignature());
        Object[] arguments= joinPoint.getArgs();
        if(arguments!=null && arguments.length!=0){
            for(Object argument : arguments){
                System.out.println("***"+argument.getClass().getSimpleName() + " = "+argument);
            }
        }
        System.out.println("**** After executing all Detailed tasks arguments : " + Arrays.toString(joinPoint.getArgs()));
    }

}