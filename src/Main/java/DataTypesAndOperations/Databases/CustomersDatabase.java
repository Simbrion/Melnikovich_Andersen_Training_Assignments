package DataTypesAndOperations.Databases;

import DataTypesAndOperations.DataTypes.Customer;
import MainPackage.Main;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomersDatabase extends Database {

    public boolean isEmpty() {
        String query = "SELECT Count(*) AS result FROM customers";
            return super.isEmpty(query);
    }

    public List<Customer> getData() {
        String query = "SELECT * FROM customers";

        try (Connection connection = Main.DATABASE_CONNECTOR.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);) {
                ArrayList<Customer> result = new ArrayList<>();
                while (resultSet.next()) {
                    Customer customer = new Customer();
                    customer.setName(resultSet.getString("name"));
                    result.add(customer);
            }
            return result;
        }
        catch (SQLException e) {
            System.out.println("getCustomers method in CustomersDatabase caught SQL exception!");
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public void removeCustomer (Customer customer)  {

        String query = "DELETE FROM customers WHERE name = ?";

        try (PreparedStatement preparedStatement = Main.DATABASE_CONNECTOR.connect().prepareStatement(query)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("removeCustomer method in CustomersDatabase caught SQL exception!");
            e.printStackTrace();
        }
    }

    public void addCustomer(Customer customer) {

        String query = "INSERT INTO customers (name) VALUES (?)";

        try (PreparedStatement preparedStatement = Main.DATABASE_CONNECTOR.connect().prepareStatement(query)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("adCustomer method in CustomersDatabase caught SQL exception!");
            e.printStackTrace();
        }

    }

}
