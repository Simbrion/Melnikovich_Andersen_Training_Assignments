package DataTypesAndOperations.Databases;

import MainPackage.Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

abstract class Database {

   abstract boolean isEmpty();

   boolean isEmpty (String query) {
       try (Connection connection = Main.DATABASE_CONNECTOR.connect();
       Statement statement = connection.createStatement();
       ResultSet resultSet = statement.executeQuery(query);) {
           resultSet.next();
           return resultSet.getInt("result") == -0;

       } catch (SQLException e) {
           e.printStackTrace();
       }
       return false;
    }

    abstract List<?> getData();

}
