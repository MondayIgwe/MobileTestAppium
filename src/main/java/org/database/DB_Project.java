package org.database;

import org.database.Entity.ClassicModelEntity;
import org.database.resource.Records;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.database.IDBQueries.*;

/*
 create a connection
 create a statement or query
 Execute and store the result
 print the result
 */
public class DB_Project {

    static ClassicModelEntity classicModelEntity;

    Connection connection;

    public DB_Project() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ClassicModels", USERROOT, PASSROOT);
            System.out.println("====== DB Connection established =========");
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

    }

    public void getResult(String query, String entityRecord) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        Records.getRecords(resultSet, classicModelEntity, entityRecord);

        connection.close();
        System.out.println("Is connection close: " + connection.isClosed());
        System.out.println("====== DB Connection closed =========");

    }

    public void getResult(String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        Records.getRecords(resultSet, classicModelEntity, null);

        connection.close();
        System.out.println("Is connection close: " + connection.isClosed());
        System.out.println("====== DB Connection closed =========");

    }
}
