package com.example;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

/**
 * Created by ThelmaAndrews on 11/1/16.
 */
@Component
public class MyTasks {
    RestTemplate template=new RestTemplate();
    private static int id=0;

    @Scheduled(cron = "* */4 * * * *") /* Every 4 minutes it is running background */
    public void addVehicle(){
        Random randomNumberGenerator=new Random();
        String randomMakeModelNumber= UUID.randomUUID().toString();
        int randomYear=randomNumberGenerator.nextInt(2016);
        double randomRetailPrice=((double) (Math.random()*(45000-15000)));
        Vehicle randomVehicle=new Vehicle(++id,randomMakeModelNumber,(randomYear+1986),(randomRetailPrice+15000));
        String url="http://localhost:8080/addVehicle";
        Vehicle vehicleObject=template.postForObject(url,randomVehicle,Vehicle.class);
        System.out.println(vehicleObject.toString());
    }

    @Scheduled(cron = "* */6 * * * *") /* Every 6 minutes it is running background */
    public void updateVehicle(){
        Random randomNumberGenerator=new Random();
        String randomMakeModelNumber=UUID.randomUUID().toString();
        Vehicle randomUpdateVehicle=new Vehicle(randomNumberGenerator.nextInt(100)+0,randomMakeModelNumber,randomNumberGenerator.nextInt(2016)+1986,((double) (Math.random()*(45000-15000)))+15000);
        String url="http://localhost:8080/updateVehicle";
        template.put(url,randomUpdateVehicle);
        System.out.println(randomUpdateVehicle.toString());
    }

    @Scheduled(cron = "* */8 * * * *") /* Every 8 minutes it is running background */
    public void deleteVehicle(){
        Random randomNumberGenerator=new Random();
        int deletedNumber=randomNumberGenerator.nextInt(100)+0;
        template.delete("http://localhost:8080/deleteVehicle/"+deletedNumber);
    }
}