package org.database;

import com.google.gson.Gson;
import org.database.Entity.ClassicModelEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.appium.utils.CommonConst.RESOURCEBASEPATH;

//     <!--Convert java object to json object using jackson api-->
public class ConvertoJson {

    public static void convertSingleJavaToJsonProcess(ClassicModelEntity classicModelEntity, String entityRecord) {
        File jsonfile = new File(RESOURCEBASEPATH + "customerInfo.json");
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            if (classicModelEntity.getBookName().equals(entityRecord))
                objectMapper.writeValue(jsonfile, classicModelEntity);
            else
                objectMapper.writeValue(jsonfile, classicModelEntity);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Conversion to Json Done!");
        }
    }

    public static void convertMultipleJavaToJsonProcess(List<ClassicModelEntity> records) {
        File jsonfile = new File(RESOURCEBASEPATH + "multipleCustomerInfo.json");
        if (jsonfile.exists()) {
            for (int i = 0; i < records.size(); i++) {
                ObjectMapper objectMapper = new ObjectMapper();

                try {
                    objectMapper.writeValue(jsonfile, records);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println("Conversion to Json Done!");
                }

            }

        } else {
            System.out.println(jsonfile.getName() + " File already exit");
        }

    }

    public static void convertSingleJavaToJsonProcessString(List<ClassicModelEntity> listOfRecord) {
        File jsonfile = new File(RESOURCEBASEPATH + "Info.json");
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();

        for (int i = 0; i < listOfRecord.size(); i++) {
            Gson gson = new Gson();
            String jsonString = gson.toJson(listOfRecord.get(i));
            jsonArray.add(jsonString);
        }

        jsonObject.put("data", jsonArray);



        if (jsonfile.exists()) {
            for (int i = 0; i < listOfRecord.size(); i++) {
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonfile, jsonObject);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } else if (!jsonfile.exists()) {
            for (int i = 0; i < listOfRecord.size(); i++) {
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonfile, jsonObject);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}
