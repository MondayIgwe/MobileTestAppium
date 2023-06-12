package org.database.resource;

import org.database.ConvertoJson;
import org.database.Entity.ClassicModelEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.database.IDBQueries.*;
import static org.database.IDBQueries.Location;

public class Records {
    public static void getRecords(ResultSet resultSet, ClassicModelEntity classicModelEntity, String entityRecord) throws SQLException {

        List<ClassicModelEntity> listOfRecord = new ArrayList<>();

        for (int i = 0; i <= listOfRecord.size(); ) {

            while (resultSet.next()) {
                classicModelEntity.setBookName(resultSet.getString(BookName));
                classicModelEntity.setPurcharsedDate(resultSet.getString(PurcharsedDate));
                classicModelEntity.setAmount(resultSet.getInt(Amount));
                classicModelEntity.setLocation(resultSet.getString(Location));

                listOfRecord.add(classicModelEntity);

                // Create Multiple json object in an array record
                ConvertoJson.convertMultipleJavaToJsonProcess(listOfRecord);

                // Create Single json object record
                ConvertoJson.convertSingleJavaToJsonProcess(classicModelEntity, entityRecord);

                // Output json object
                ConvertoJson.convertSingleJavaToJsonProcessString(listOfRecord);

                System.out.printf("bookName: %s, purchasedDate: %s, amount: %d, location: %s, \n", classicModelEntity.getBookName(), classicModelEntity.getPurcharsedDate(), classicModelEntity.getAmount(), classicModelEntity.getLocation());

            }

            System.out.println("loop Counter " + i);
            break;

        }
    }
}
