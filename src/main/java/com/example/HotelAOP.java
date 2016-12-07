package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class HotelAOP {
    @Before("execution(* com.example.HotelDAO.enterintoHotel(..))")
    public void beforeEnterIntoHotel(JoinPoint joinPoint){
        System.out.println("before entering into hotel : " + joinPoint.getSignature().getName());
    }
    @Before("execution(* com.example.HotelDAO.*(..))")
    public void beforeAllHotemMethodsLog(JoinPoint joinPoint){
        System.out.println("before all hotel methods : " + joinPoint.getSignature().getName());
    }
    @After("execution(* com.example.HotelDAO.enterintoHotel(..))")
    public void afterEnterIntoHotel(JoinPoint joinPoint){
        System.out.println("after entering into hotel : " + joinPoint.getSignature().getName());
    }
    @After("execution(* com.example.HotelDAO.*(..))")
    public void afterAllHotemMethodsLog(JoinPoint joinPoint){
        System.out.println("after all hotel methods : " + joinPoint.getSignature().getName());
    }
}

