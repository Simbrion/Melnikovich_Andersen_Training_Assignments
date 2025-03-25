package DataTypesAndOperations.Databases;

import DataTypesAndOperations.DataTypes.Reservation;
import MainPackage.Main;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReservationsDatabase extends Database {


    public boolean isEmpty() {
        String query = "SELECT Count(*) AS result FROM reservations";
        return super.isEmpty(query);
    }

    public List<Reservation> getData() {

        String query = "SELECT * FROM reservations";

        try (Connection connection = Main.DATABASE_CONNECTOR.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);) {
            ArrayList<Reservation> result = new ArrayList<>();

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setId(resultSet.getInt("id"));
                reservation.setSpace(resultSet.getString("space_name"));
                reservation.setCustomer(resultSet.getString("customer_name"));
                reservation.setDate(resultSet.getDate("date").toLocalDate());
                reservation.setStartTime(resultSet.getTime("start_time").toLocalTime());
                reservation.setEndTime(resultSet.getTime("end_time").toLocalTime());
                result.add(reservation);
            }
            return result;
        }
        catch (SQLException e) {
            System.out.println("getReservations method in ReservationsDatabase caught SQL exception!");
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public void removeReservation (Reservation reservation)  {

        String query = "DELETE FROM reservations WHERE id = ?";

        try (PreparedStatement preparedStatement = Main.DATABASE_CONNECTOR.connect().prepareStatement(query)) {
            preparedStatement.setInt(1, reservation.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("removeReservation method in ReservationsDatabase caught SQL exception!");
            e.printStackTrace();
        }
    }

    public void addReservation(Reservation reservation) {

        String query = "INSERT INTO reservations (customer_name, space_name, date, start_time, end_time) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = Main.DATABASE_CONNECTOR.connect().prepareStatement(query)) {
            preparedStatement.setString(1, reservation.getCustomerName());
            preparedStatement.setString(2, reservation.getSpace().getName());
            preparedStatement.setDate(3, Date.valueOf(reservation.getDate()));
            preparedStatement.setTime(4, Time.valueOf(reservation.getStartTime()));
            preparedStatement.setTime(5, Time.valueOf(reservation.getEndTime()));
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("addReservation method in reservationsDatabase caught SQL exception!");
            e.printStackTrace();
        }
    }

    public int getCurrentIndex() {
        String query = "SELECT MAX(id) FROM reservations";

        try (Connection connection = Main.DATABASE_CONNECTOR.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);) {
             resultSet.next();
             return resultSet.getInt("MAX(id)");
        } catch (SQLException e) {
            System.out.println("getCurrentIndex method in ReservationsDatabase caught SQL exception!");
            e.printStackTrace();
        }
        return 0;
    }

}
