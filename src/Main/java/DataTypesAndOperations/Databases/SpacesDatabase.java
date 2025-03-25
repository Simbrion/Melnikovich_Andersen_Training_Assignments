package DataTypesAndOperations.Databases;

import DataTypesAndOperations.DataTypes.Space;
import MainPackage.Main;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpacesDatabase extends Database {


    public boolean isEmpty() {
        String query = "SELECT Count(*) AS result FROM spaces";
            return super.isEmpty(query);
        }

    public List<Space> getData() {

        String query = "SELECT * FROM spaces";

        try (Connection connection = Main.DATABASE_CONNECTOR.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);) {
            ArrayList<Space> result = new ArrayList<>();
            while (resultSet.next()) {
                Space space = new Space();
                space.setName(resultSet.getString("name"));
                space.setPrice(resultSet.getInt("price"));
                space.setType(resultSet.getString("type"));
                result.add(space);
            }
            return result;
        }
        catch (SQLException e) {
            System.out.println("getSpaces method in SpacesDatabase caught SQL exception!");
            System.out.println(e.getErrorCode());
        }
    return Collections.emptyList();
    }

    public void addSpace (Space space) {

        String query = "INSERT INTO spaces (name, price, type) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = Main.DATABASE_CONNECTOR.connect().prepareStatement(query)) {
            preparedStatement.setString(1, space.getName());
            preparedStatement.setInt(2, space.getPrice());
            preparedStatement.setString(3, space.getTypeAsString());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("addSpace method in SpacesDatabase caught SQL exception!");
            System.out.println(e.getErrorCode());
        }
    }

    public void removeSpace (Space space)  {

        String query = "DELETE FROM spaces WHERE name = ?";

        try (PreparedStatement preparedStatement = Main.DATABASE_CONNECTOR.connect().prepareStatement(query)) {
            preparedStatement.setString(1, space.getName());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("removeSpace method in SpacesDatabase caught SQL exception!");
            e.printStackTrace();
        }
    }

}
