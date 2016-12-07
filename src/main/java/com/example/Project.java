package com.example;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.commons.lang3.CharEncoding;
//impor org.apache.tomcat.jni.File;
//import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.io.*;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import org.apache.commons.io.FileUtils;

//import static sun.security.krb5.Confounder.intValue;
//import java.io.IOException;
//import static org.apache.commons.io.FileUtils.writeStringToFile;
/**
 * Created by ThelmaAndrews on 11/1/16.
 */
@RestController
public class Project {
    public static String getFilePath = "/Users/ThelmaAndrews/Desktop/inventory.txt";

    @RequestMapping(value = "/addVehicle", method = RequestMethod.POST)
    public Vehicle addVehicle(@RequestBody Vehicle V) throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            FileWriter output = new FileWriter("/Users/ThelmaAndrews/Desktop/inventory.txt", true);
            mapper.writeValue(output, V);
            FileUtils.writeStringToFile(new File("/Users/ThelmaAndrews/Desktop/inventory.txt"), System.lineSeparator(), CharEncoding.UTF_8, true);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return V;

    }

    @RequestMapping(value = "/getVehicle/{id}", method = RequestMethod.GET)
    public Vehicle getVehicle(@PathVariable("id") int id) throws IOException {
        Vehicle getV = null;
        BufferedReader bufferedReader = null;
        try {
            File file = new File(getFilePath);
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            //String readtext = "";
            String readLineFromFile = bufferedReader.readLine();
            do {
                if (readLineFromFile.trim().length() != 0) {
                    JSONParser jsonparser = new JSONParser();
                    Object object = jsonparser.parse(readLineFromFile);
                    JSONObject jsonobject = (JSONObject) object;
                    if (((Long) jsonobject.get("id")).intValue() == id) {
                        getV = new Vehicle(((Long) jsonobject.get("id")).intValue(), (String) jsonobject.get("makeModel"), Integer.parseInt("" + (Long) jsonobject.get("year")), ((Double) jsonobject.get("retailPrice")).doubleValue());
                        break;
                    }

                }
            }
            while ((readLineFromFile = bufferedReader.readLine()) != null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }

        //ObjectMapper mapper = new ObjectMapper();
        //String message2 = FileUtils.readFileToString(new File("/Users/ThelmaAndrews/Desktop/test.txt"), CharEncoding.UTF_8);
        //Vehicle V = mapper.readValue(, Vehicle.class);
        // greeting.toString();
        //mapper.writeValue(new File("/Users/ThelmaAndrews/Desktop/message.txt"), greeting);
        return getV;
    }

    @RequestMapping(value = "/updateVehicle", method = RequestMethod.PUT)
    public Vehicle updateVehicle(@RequestBody Vehicle V) throws IOException {
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        try {
            File file = new File(getFilePath);
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            int getPosition = 0, indexIncrement = 1;
            Vector<String> reWriteObjects = new Vector<String>();
            String readLineFromFile = bufferedReader.readLine();
            do {
                if (readLineFromFile.trim().length()!= 0) {
                    JSONParser jsonParser = new JSONParser();
                    Object object = jsonParser.parse(readLineFromFile);
                    JSONObject jsonObject = (JSONObject) object;
                    if (((Long) jsonObject.get("id")).intValue() == V.getId()) {
                        reWriteObjects.add(readLineFromFile);
                        getPosition = indexIncrement;
                    } else {
                        reWriteObjects.add(readLineFromFile);
                    }
                    indexIncrement++;
                }
            } while ((readLineFromFile = bufferedReader.readLine()) != null);

            if (getPosition != 0) {
                FileWriter fileWriter = new FileWriter(file);
                for (int index = 0; index < reWriteObjects.size(); index++) {
                    if ((getPosition - 1) == index) {
                        ObjectMapper mapper = new ObjectMapper();
                        FileWriter output = new FileWriter(getFilePath, true);
                        mapper.writeValue(output, V);
                        FileUtils.writeStringToFile(file, System.lineSeparator(), CharEncoding.UTF_8, true);
                    } else {
                        fileWriter = new FileWriter(file, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        printWriter = new PrintWriter(bufferedWriter);
                        printWriter.println((String) reWriteObjects.get(index));
                        printWriter.close();
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
        return V;

    }

    @RequestMapping(value="/deleteVehicle/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteVehicle(@PathVariable("id") int id) throws IOException{
        try{
            File file=new File("/Users/ThelmaAndrews/Desktop/inventory.txt");
            FileReader filereader=new FileReader(file);
            BufferedReader bufferedreader=new BufferedReader(filereader);
            String readtext="";
            boolean checkDeleteId=false;
            ArrayList remainingObjects=new ArrayList();
            while((readtext=bufferedreader.readLine())!= null && readtext.trim().length()!=0){
                JSONParser jsonParser=new JSONParser();
                Object object=jsonParser.parse(readtext);
                JSONObject jsonObject=(JSONObject)object;
                if(!((Long)jsonObject.get("id")==id)){
                    remainingObjects.add(readtext);
                }else{
                    checkDeleteId=true;
                }
            }
            if(checkDeleteId==true);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity("NOT FOUND", HttpStatus.OK);
    }
}