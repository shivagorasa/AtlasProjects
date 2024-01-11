package makemytripTest.makemytripTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class TestJdbc {

    public static void main(String[] args) {
        createTables();
        insertData();
        findDuplicateRecords();
    }
@Test
    public static void createTables() {
        try {
            Connection connection = Jdbcconnection.getConnection();
            Statement statement = connection.createStatement();

            // Order Table
            statement.executeUpdate("CREATE TABLE OrderTable (OrderId INT, ProductName VARCHAR(255), Price DOUBLE)");

            // Customer Table
            statement.executeUpdate("CREATE TABLE CustomerTable (CustomerId INT, CustomerName VARCHAR(255), Region VARCHAR(255))");

            // Sales Table
            statement.executeUpdate("CREATE TABLE SalesTable (SaleId INT, OrderId INT, CustomerId INT, Quantity INT, SaleDate DATE)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
@Test
    public static void insertData() {
        try {
            Connection connection = Jdbcconnection.getConnection();

            // Insert into OrderTable
            PreparedStatement orderStatement = connection.prepareStatement("INSERT INTO OrderTable VALUES (?, ?, ?)");
            orderStatement.setInt(1, 1);
            orderStatement.setString(2, "Product1");
            orderStatement.setDouble(3, 50.0);
            orderStatement.executeUpdate();

            // Insert into CustomerTable
            PreparedStatement customerStatement = connection.prepareStatement("INSERT INTO CustomerTable VALUES (?, ?, ?)");
            customerStatement.setInt(1, 1);
            customerStatement.setString(2, "Customer1");
            customerStatement.setString(3, "Region1");
            customerStatement.executeUpdate();

            // Insert into SalesTable
            PreparedStatement salesStatement = connection.prepareStatement("INSERT INTO SalesTable VALUES (?, ?, ?, ?, ?)");
            salesStatement.setInt(1, 1);
            salesStatement.setInt(2, 1);
            salesStatement.setInt(3, 1);
            salesStatement.setInt(4, 5);
            salesStatement.setString(5, "2023-11-25"); // Use an actual date format
            salesStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
@Test
    public static void findDuplicateRecords() {
        try {
            Connection connection = Jdbcconnection.getConnection();
            Statement statement = connection.createStatement();

            // Example: Find duplicate ProductName in OrderTable
            String query = "SELECT ProductName, COUNT(*) FROM OrderTable GROUP BY ProductName HAVING COUNT(*) > 1";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("Duplicate ProductName: " + resultSet.getString("ProductName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
