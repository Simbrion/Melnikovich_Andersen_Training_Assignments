package DataTypesAndOperations.DiskDataOperation;

import DataTypesAndOperations.DataTypes.Customer;
import DataTypesAndOperations.DataTypes.Reservation;
import DataTypesAndOperations.DataTypes.Space;
import Main.Config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.BaseStream;
import java.util.stream.Stream;


public class DataDeleter {

    public void deleteReservationData (Reservation reservation) {
        Stream<Path> fileStream = null;
        try {
            fileStream = Files.list(Config.DATASAVE_DIRECTORY);
            fileStream
                    .filter(path -> path.getFileName().toString().startsWith("Reservation_"))
                    .filter(path -> path.getFileName().toString().endsWith("ID_" + reservation.getId() + ".bin"))
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                            System.out.println(Config.YELLOW_COLOUR + "Data related to reservation by " + reservation.getCustomerName() + "with ID " + reservation.getId() + "has been deleted from Data folder." + Config.RESET_COLOUR);
                        } catch (IOException e) {
                            System.out.println("IO exception caught when trying to delete the reservation file!");
                        }
                    });
        } catch ( IOException e ) {
            System.out.println(Config.WRONG_INPUT_EXCEPTION);
        }
        finally {
            Optional.ofNullable(fileStream).ifPresent(BaseStream::close);
        }
    }

    public void deleteSpaceData(Space space) {
        Stream<Path> fileStream = null;
        try {
            fileStream = Files.list(Config.DATASAVE_DIRECTORY);
            fileStream
                    .filter(path -> path.getFileName().toString().startsWith("Space_" + space.getName()))
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                            System.out.println(Config.YELLOW_COLOUR + "Data related to space named " + space.getName() + "has been deleted from Data folder." + Config.RESET_COLOUR);
                        } catch (IOException e) {
                            System.out.println("IO exception caught when trying to delete the space file!");
                        }
                    });
        } catch ( IOException e ) {
            System.out.println(Config.WRONG_INPUT_EXCEPTION);
        }
        finally {
            Optional.ofNullable(fileStream).ifPresent(BaseStream::close);
        }
    }

    public void deleteCustomerData(Customer customer) {
        Stream<Path> fileStream = null;
        try {
            fileStream = Files.list(Config.DATASAVE_DIRECTORY);
            fileStream
                    .filter(path -> path.getFileName().toString().startsWith("Customer_" + customer.getName()))
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                            System.out.println(Config.YELLOW_COLOUR + "Data related to customer " + customer.getName() + "has been deleted from Data folder.");
                        } catch (IOException e) {
                            System.out.println("IO exception caught when trying to delete the customer file!");
                        }
                    });
        } catch (IOException e) {
            System.out.println(Config.WRONG_INPUT_EXCEPTION);
        }
        finally {
            Optional.ofNullable(fileStream).ifPresent(BaseStream::close);
        }

    }

}
