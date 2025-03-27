package DataTypesAndOperations.ReservationOperators;

import DataTypesAndOperations.DataTypes.Customer;
import DataTypesAndOperations.DataTypes.Reservation;
import MainPackage.*;

import java.io.IOException;
import java.util.List;

public class ReservationCanceler {

    public void cancelReservation(Customer customer) throws IOException {

        if (Main.RESERVATIONS_DATABASE.isEmpty() || customer.getReservations().isEmpty()) {
            System.out.println(Config.YELLOW_COLOUR + "You have no reservations." + Config.RESET_COLOUR);
            Main.CUSTOMER_MENU.getToMenu(customer);
        }

        try {
            System.out.println("Please indicate ID of the reservation to be cancelled.");
            Main.RESERV_LIST_VIEWER.printCustomerReservationsList(customer);
            String userInput = Main.READER.readLine();
            if (Main.INPUT_VALIDATOR.validate(Main.POSITIVE_DIGIT_VALIDATOR, userInput)) {
                performDeletion(userInput, customer);
            } else {
                System.out.println(Config.WRONG_INPUT_MESSAGE);
                Main.CUSTOMER_MENU.getToMenu(customer);
            }
        } catch (IOException exception) {
            System.out.println(Config.WRONG_INPUT_EXCEPTION);
        }
    }

    private void performDeletion(String userInput, Customer customer) throws IOException {
        boolean foundReservationToDelete = false;
        List<Reservation> currentReservationsList = Main.RESERVATIONS_DATABASE.getData();
        for (int i = 0; i < currentReservationsList.size(); i++) {
            if ((Integer.parseInt(userInput) == currentReservationsList.get(i).getId()) && (currentReservationsList.get(i).getId() == customer.getId())) {
                Main.RESERVATIONS_DATABASE.removeReservation(currentReservationsList.get(i));
                currentReservationsList.remove(currentReservationsList.get(i));
                System.out.println(Config.GREEN_COLOUR + "Reservation has been successfully cancelled!" + Config.RESET_COLOUR);
                foundReservationToDelete = true;
                break;
            }
        }

        if (!foundReservationToDelete) {
            System.out.println(Config.RED_COLOUR + "Can't find your reservation ith such ID." + Config.RESET_COLOUR);
            Main.CUSTOMER_MENU.getToMenu(customer);
        }
        Main.CUSTOMER_MENU.getToMenu(customer);
    }
}


