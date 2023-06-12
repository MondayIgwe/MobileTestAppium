package database;

import java.sql.*;

import static org.utils.IDBQueries.*;

/*
 create a connection
 create a statemen or query
 Execute and store the result
 print the result
 */
public class DB_Project {

    Connection connection;

    public DB_Project() {
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ClassicModels", USERROOT, PASSROOT);
            System.out.println("====== DB Connection established =========");
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }

    }

    public void getResult() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECTALLCUSTOMERTABLE);

        while (resultSet.next()) {
            String bookName = resultSet.getString(BookName);
            String purchahsedDate = resultSet.getString(PurchahsedDate);
            int amount = resultSet.getInt(Amount);
            String location = resultSet.getString(Location);

            System.out.printf("bookName: %s, purchahsedDate: %s, amount: %d, location: %s, \n", bookName, purchahsedDate, amount, location );
        }

        connection.close();
        System.out.println("Is connection close: " + connection.isClosed());
        System.out.println("====== DB Connection closed =========");
    }
}
