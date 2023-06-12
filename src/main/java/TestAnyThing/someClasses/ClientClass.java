package TestAnyThing.someClasses;

import TestAnyThing.sometest.IAbstractTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

public class ClientClass extends IAbstractTest {

    int timer = 2000;
    @Override
    public LocalDateTime getTime() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.get("apiDemo");

       JSONArray jsonArray = (JSONArray)jsonObject.values();

        Set<String> set = jsonObject.keySet();
        for(String key : set){
            System.out.println(key.toLowerCase());

            Collection<String> values = jsonObject.values();
            for (String value : values){
                System.out.println(key + " " + value);
            }

            jsonArray.forEach((n)-> n.toString().toLowerCase());
        }

        return LocalDateTime.now();
    }

    public static void main(String[] args) {
        ClientClass  clientClass1 = new ClientClass();
        ClientClass clientClass2 = new ClientClass();

        clientClass1.getTime();
    }
}
