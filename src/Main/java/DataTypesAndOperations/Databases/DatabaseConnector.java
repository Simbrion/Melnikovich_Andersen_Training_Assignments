package DataTypesAndOperations.Databases;

import MainPackage.Main;

import java.sql.*;

public class DatabaseConnector {

    public Connection connect() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/sra_db";
        String user = "root";
        String password = "SimbrionRoot321!";
        return DriverManager.getConnection(url, user, password);

    }

}
