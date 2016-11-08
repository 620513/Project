package com.example;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.math.BigInteger;
import java.security.SecureRandom;
/**
 * Created by ThelmaAndrews on 11/1/16.
 */
@Component
public class MyTasks {
    private static int id=1;
    RestTemplate restTemplate = new RestTemplate();
    @Scheduled(cron ="*/1 * * * * *")
    public void addVehicle(){
        String url = "http://localhost:8080/addVehicle";
        int year=((int)(Math.random()*(2016-1986)))+1986;
        double retailPrice=((double) (Math.random()*(45000-15000)))+15000;
        SecureRandom randomValue = new SecureRandom();
        Vehicle V = new Vehicle(id++,new BigInteger(130, randomValue).toString(32),year,retailPrice);
        Vehicle vehicle= restTemplate.postForObject(url,V,Vehicle.class);
        System.out.println(vehicle.toString());
    }


    @Scheduled(cron ="*/8 * * * * *")
    public void updateVehicle(){
        String url ="http://localhost:8080/updateVehicle";
        int year=1921;
        double retailPrice = 11111.54;
        int randomValue=((int)(Math.random()*(86-0)))+0;
        String makeModel = "333333";
        SecureRandom securerandomValue = new SecureRandom();
        Vehicle V = new Vehicle (randomValue,makeModel,year,retailPrice);
        restTemplate.put(url,V);
        String updateVehicle ="http://localhost:8080/getVehicle/"+ Integer.toString(randomValue);
        Vehicle vehicle = restTemplate.getForObject(updateVehicle,Vehicle.class);
        System.out.println("update"+ randomValue);
        System.out.println("update " + vehicle);
    }

    @Scheduled(cron ="*/6 * * * * *")
    public void deleteVehicle(){
      int randomValue=((int)(Math.random()*(77-0)))+0;
        String url="http://localhost:8080/deleteVehicle/"+randomValue;
        try {
            restTemplate.delete(url);
            System.out.println("deleted "+randomValue);
        } catch (Exception e) {
           System.out.println("Delete id "+randomValue+" not found");
        }
    }
}





