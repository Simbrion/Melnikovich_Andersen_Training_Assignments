package DataTypesAndOperations.DiskDataOperation;

import DataTypesAndOperations.DataTypes.Space;
import MainPackage.*;
import DataTypesAndOperations.DataTypes.Reservation;
import DataTypesAndOperations.DataTypes.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class DataLoader {

    private static final Pattern customerFileNamePattern = Pattern.compile("^Customer.*\\.bin$");
    private static final Pattern spaceFileNamePattern = Pattern.compile("^Space.*\\.bin$");
    private static final Pattern reservationFileNamePattern = Pattern.compile("^Reservation.*\\.bin$");

    private static final ArrayList<File> uploadedCustomerFiles = new ArrayList<>();
    private static final ArrayList<File> uploadedSpaceFiles = new ArrayList<>();
    private static final ArrayList<File> uploadedReservationFiles = new ArrayList<>();


    public void loadData() {

        File[] customerFilesInDataFolder = getCustomerFiles(Config.DATASAVE_DIRECTORY_FILE);
        File[] spacesFilesInDataFolder = getSpacesFiles(Config.DATASAVE_DIRECTORY_FILE);
        File[] reservationFilesInDataFolder = getReservationFiles(Config.DATASAVE_DIRECTORY_FILE);

        uploadCustomerFiles(customerFilesInDataFolder);
        uploadSpaceFiles(spacesFilesInDataFolder);
        uploadReservationFiles(reservationFilesInDataFolder);

        //Reservations IDCount adjustment
        int maxIndex = 1;
        for (Customer customer : Main.CUSTOMERS) {
            for (Reservation reservation : customer.getReservations()) {
                if (reservation.getId() > maxIndex) maxIndex = reservation.getId();
                Main.RESERV_CREATOR.setReservIdCount(maxIndex + 1);
            }
        }

        System.out.println("\n\n");
    }

    private File[] getCustomerFiles(File file) {

        return file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return customerFileNamePattern.matcher(name).matches();
            }
        });
    }

    private File[] getSpacesFiles(File file) {

        return file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return spaceFileNamePattern.matcher(name).matches();
            }
        });
    }

    private File[] getReservationFiles(File file) {

        return file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return reservationFileNamePattern.matcher(name).matches();
            }
        });
    }

    private void uploadCustomerFiles(File[] customerFilesInDataFolder) {
        for (int i = 0; i < customerFilesInDataFolder.length; i++) {
            System.out.println(Config.YELLOW_COLOUR + "Found customer file  " + customerFilesInDataFolder[i].toString() + Config.RESET_COLOUR);

            try {
                FileInputStream fileInputStream = new FileInputStream(customerFilesInDataFolder[i]);
                ObjectInputStream  objectOutputStream = new ObjectInputStream (fileInputStream);
                Customer customer = (Customer) objectOutputStream.readObject();

                boolean isAlreadyInSystem = false;
                for (Customer existingCustomer : Main.CUSTOMERS) {
                    if (customer.equals(existingCustomer)) {
                        isAlreadyInSystem = true;
                        System.out.println(Config.YELLOW_COLOUR + "Customer exists in the system: " + Config.RESET_COLOUR);
                        System.out.println(Config.YELLOW_COLOUR + customer.getName() + Config.RESET_COLOUR);
                    }
                }
                if (!isAlreadyInSystem) {
                    Main.CUSTOMERS.add(customer);
                    System.out.println(Config.YELLOW_COLOUR + "Customer uploaded: " + customer.getName() + Config.RESET_COLOUR);
                    customer.getName();
                }
                fileInputStream.close();
                objectOutputStream.close();
            }
            catch (IOException e) {
                System.out.println(Config.RED_COLOUR + "IOException caught!" + Config.RESET_COLOUR);
            }
            catch (ClassNotFoundException e) {
                System.out.println(Config.RED_COLOUR + "ClassNotFoundException caught!" + Config.RESET_COLOUR);
            }
        }
    }

    private void uploadSpaceFiles(File[] spacesFilesInDataFolder) {

        for (int i = 0; i < spacesFilesInDataFolder.length; i++) {
            System.out.println(Config.YELLOW_COLOUR + "Found space file  " + spacesFilesInDataFolder[i].toString() + Config.RESET_COLOUR);
            try {
                FileInputStream fileInputStream = new FileInputStream(spacesFilesInDataFolder[i]);
                ObjectInputStream  objectOutputStream = new ObjectInputStream (fileInputStream);
                Space space = (Space) objectOutputStream.readObject();

                boolean isAlreadyInSystem = false;
                for (Space existingSpace : Main.SPACES) {
                    if (space.equals(existingSpace)) {
                        isAlreadyInSystem = true;
                        System.out.println(Config.YELLOW_COLOUR + "Space exists in the system: " + Config.RESET_COLOUR);
                        space.printDescription();
                    }
                }
                if (!isAlreadyInSystem) {
                    Main.SPACES.add(space);
                    System.out.println(Config.YELLOW_COLOUR + "Space uploaded: " + Config.RESET_COLOUR);
                    space.printDescription();
                }
                fileInputStream.close();
                objectOutputStream.close();
            }
            catch (IOException e) {
                System.out.println(Config.RED_COLOUR + "IOException caught!" + Config.RESET_COLOUR);
            }
            catch (ClassNotFoundException e) {
                System.out.println(Config.RED_COLOUR + "ClassNotFoundException caught!" + Config.RESET_COLOUR);
            }
        }
    }

    private void uploadReservationFiles(File[] reservationFilesInDataFolder) {

        for (int i = 0; i < reservationFilesInDataFolder.length; i++) {
            System.out.println(Config.YELLOW_COLOUR + "Found reservation file " + reservationFilesInDataFolder[i].toString() + Config.RESET_COLOUR);

            try {
                FileInputStream fileInputStream = new FileInputStream(reservationFilesInDataFolder[i]);
                ObjectInputStream  objectOutputStream = new ObjectInputStream (fileInputStream);
                Reservation reservation = (Reservation) objectOutputStream.readObject();
                boolean isAlreadyInSystem = false;
                for (Reservation existingReservation : Main.RESERVATIONS) {
                    if (reservation.equals(existingReservation)) {
                        isAlreadyInSystem = true;
                        System.out.println(Config.YELLOW_COLOUR + "Reservation exists in the system: " + Config.RESET_COLOUR);
                        reservation.printDescription();
                    }
                }
                if (!isAlreadyInSystem) {
                    Main.RESERVATIONS.add(reservation);
                    System.out.println(Config.YELLOW_COLOUR + "Reservation uploaded: " + Config.RESET_COLOUR);
                    reservation.printDescription();
                }
                fileInputStream.close();
                objectOutputStream.close();
            }
            catch (IOException e) {
                System.out.println(Config.RED_COLOUR + "IOException caught!" + Config.RESET_COLOUR);
            }
            catch (ClassNotFoundException e) {
                System.out.println(Config.RED_COLOUR + "ClassNotFoundException caught!" + Config.RESET_COLOUR);
            }
        }
    }
}
