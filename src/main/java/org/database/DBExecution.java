package org.database;

import java.sql.SQLException;

import static org.database.IDBQueries.*;

// Presentation Layer
public class DBExecution {
    static DB_Project dbProject = new DB_Project();

    public static void main(String[] args) throws SQLException {
        dbProject.getResult(SELECTALLCUSTOMERTABLE);
    }
}
