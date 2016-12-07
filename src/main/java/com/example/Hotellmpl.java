package com.example;

public class Hotellmpl implements HotelInterface {
    public void enterintoHotel(){
        System.out.println("This method calling when customers enter into the hotel or visit the hotel");
    }
    public void enterintoHotelThrowException() throws Exception {
        System.out.println("This method calling when customers enter into the hotel or visit the hotel throws exception");
        throw new Exception("Generic Error");
    }
    public void enterintoHotelAround(){
        System.out.println("This method calling when customers enter into the hotel or visit the hotel around");
    }
}
