package database;

import java.sql.SQLException;

public class DBExecution {
    // Presentation Layer
    public static void main(String[] args) throws SQLException {
        DB_Project dbProject = new DB_Project();
        dbProject.getResult();
    }
}
