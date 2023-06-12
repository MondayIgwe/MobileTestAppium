package org.database;

import org.database.Entity.ClassicModelEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

//     <!--Convert java object to json object using jackson api-->
public class ConvertoJson {

    public static void convertSingleJavaToJsonProcess(ClassicModelEntity classicModelEntity, String entityRecord) {
        File jsonfile = new File(System.getProperty("user.dir") + "/src/main/java/org/database/resource/customerInfo.json");
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
        File jsonfile = new File(System.getProperty("user.dir") + "/src/main/java/org/database/resource/multipleCustomerInfo.json");
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
}
