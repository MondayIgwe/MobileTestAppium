package org.appium.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CapabilityFactory {

    private static JSONArray parseJson(String jsonCapabilities){
        try{
            JSONParser jsonParser = new JSONParser();
          return (JSONArray) jsonParser.parse(new FileReader(jsonCapabilities));
        }catch (Exception e){

        }

        return null;
    }


    private static JSONObject getCapabilitiesConfig(String capabilityName, String jsonLocation) {
        try {
            JSONArray jsonCapabilities = parseJson(jsonLocation);

            for(Object jsonObj : jsonCapabilities){
                JSONObject capability =  (JSONObject)jsonObj;
                if(capability.get("name").toString().equalsIgnoreCase(capabilityName))
                    return (JSONObject) capability.get("caps");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    private static HashMap<String, Object> convertCapsToHashMap(String capabilityName, String jsonLocation) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(getCapabilitiesConfig(capabilityName, jsonLocation).toString(), HashMap.class);
    }

    public static DesiredCapabilities getDesiredCapabilities(String capabilityName, String capsContentRootLocaton) throws IOException {
       String jsonLocation = System.getProperty("user.dir") + "/" + capsContentRootLocaton;
       HashMap<String, Object> caps = convertCapsToHashMap(capabilityName, jsonLocation);
       return new DesiredCapabilities(caps);
    }

}
