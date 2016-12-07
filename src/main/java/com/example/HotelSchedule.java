package com.example;

import java.util.Random;
import java.util.UUID;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HotelSchedule {
    @Scheduled(cron = "*/2 * * * * *")
    public void enterintoHotel() {
        HotelDAO hotelDAO=new HotelDAO();
        hotelDAO.enterintoHotel();
    }
    @Scheduled(cron = "*/4 * * * * *")
    public void orderingbuffet() {
        HotelDAO hotelDAO=new HotelDAO();
        hotelDAO.orderingbuffet();
    }
    @Scheduled(cron = "*/6 * * * * *")
    public void eatingbuffet() {
        HotelDAO hotelDAO=new HotelDAO();
        hotelDAO.eatingbuffet();
    }
    @Scheduled(cron = "*/8 * * * * *")
    public void exitfromhotel() {
        HotelDAO hotelDAO=new HotelDAO();
        hotelDAO.exitfromhotel();
    }
}
