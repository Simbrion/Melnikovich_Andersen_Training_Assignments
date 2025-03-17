package DataTypesAndOperations.DiskDataOperation;

import DataTypesAndOperations.DataTypes.*;
import MainPackage.*;
import UtilityServices.CustomExceptions.DataFolderNotFoundException;


import java.io.*;
import java.nio.file.Files;

public class DataSaver {

    private static final String DATA_FOLDER_NOT_FOUND = "Data folder not found!";

    public void saveSessionData () throws IOException {

        //Saving customers
        for (Customer customer : Main.CUSTOMERS) {

            try (FileOutputStream outputStream = new FileOutputStream(Config.DATASAVE_DIRECTORY + "/" + "Customer_" + customer.getName() + ".bin")){

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(customer);

            }
            catch (FileNotFoundException fileNotFoundException) {
                if (!Files.exists(Config.DATASAVE_DIRECTORY)) throw new DataFolderNotFoundException(DATA_FOLDER_NOT_FOUND);
            }
            System.out.println(Config.YELLOW_COLOUR + String.format("Data related to customer %s has been saved to */Data directory.",
                                                                    customer.getName()) + Config.RESET_COLOUR);
        }

        //Saving reservations
        for (Reservation reservation : Main.RESERVATIONS) {
            Files.createDirectories(Config.DATASAVE_DIRECTORY);

            try (FileOutputStream outputStream = new FileOutputStream(Config.DATASAVE_DIRECTORY + "/" + "Reservation_" + reservation.getCustomerName() + "_ID_" + reservation.getId() + ".bin")){

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(reservation);

            }
            catch (FileNotFoundException fileNotFoundException) {
                if (!Files.exists(Config.DATASAVE_DIRECTORY)) throw new DataFolderNotFoundException(DATA_FOLDER_NOT_FOUND);
            }
            System.out.println(Config.YELLOW_COLOUR + String.format("Data related to reservation with ID %d by customer %s has been saved to */Data directory.",
                                                        reservation.getId(),
                                                        reservation.getCustomerName()) + Config.RESET_COLOUR);
        }

        //Saving spaces
        for (Space space : Main.SPACES) {
            Files.createDirectories(Config.DATASAVE_DIRECTORY);

            try (FileOutputStream outputStream = new FileOutputStream(Config.DATASAVE_DIRECTORY + "/" + "Space_" + space.getName() + ".bin")){

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(space);

            }
            catch (FileNotFoundException fileNotFoundException) {
                if (!Files.exists(Config.DATASAVE_DIRECTORY)) throw new DataFolderNotFoundException(DATA_FOLDER_NOT_FOUND);
            }
            System.out.println(Config.YELLOW_COLOUR + String.format("Data related to space named %s has been saved to */Data directory.",
                                                        space.getName()) + Config.RESET_COLOUR);
        }


    }

}
