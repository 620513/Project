package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHotelAOP{
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/example/applicationContext.xml");
        HotelDAO hoteldao = context.getBean(HotelDAO.class);
        hoteldao.enterintoHotel();
    }
}

