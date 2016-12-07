package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HotelDAO{
    public void enterintoHotel() {
        System.out.println("This method is customers enter into the hotel for eating something");
    }

    public void orderingbuffet() {
        System.out.println("customers ordering buffet to bannner");
    }

    public void eatingbuffet() {
        System.out.println("eating ordered buffet");
    }

    public void exitfromhotel() {
        System.out.println("happily leave from hotel");
    }
}
