import java.io.IOException;

public class ReservationCanceller {

    public void cancelReservation(Customer customer) throws IOException {

        if (Main.RESERVATIONS.isEmpty() || customer.getReservations().isEmpty()) {
            System.out.println(Config.YELLOW_COLOUR + "You have no reservations." + Config.RESET_COLOUR);
            customer.getToMenu();
        }

        try {
            System.out.println("Please indicate ID of the reservation to be cancelled.");
            Main.RESERV_LIST_VIEWER.printCustomerReservationsList(customer);
            String userInput = Main.READER.readLine();
            if (Main.INPUT_VALIDATOR.validate(Main.POSITIVE_DIGIT_VALIDATOR, userInput)) {
                performDeletion(userInput, customer);
            } else {
                System.out.println(Config.WRONG_INPUT_MESSAGE);
                customer.getToMenu();
            }
        } catch (IOException e) {
            System.out.println(Config.WRONG_INPUT_EXCEPTION);
        }
    }

    private void performDeletion(String userInput, Customer customer) throws IOException {
        boolean foundReservationToDelete = false;
        for (int i = 0; i < Main.RESERVATIONS.size(); i++) {
            if ((Integer.parseInt(userInput) == Main.RESERVATIONS.get(i).getId()) && (Main.RESERVATIONS.get(i).getCustomerName().equalsIgnoreCase(customer.getName()))) {
                Main.RESERVATIONS.remove(Main.RESERVATIONS.get(i));
                System.out.println(Config.GREEN_COLOUR + "Reservation has been successfully cancelled!" + Config.RESET_COLOUR);
                foundReservationToDelete = true;
                break;
            }
        }

        if (foundReservationToDelete) {
            for (Reservation reservation : customer.getReservations()) {
                 if (Integer.parseInt(userInput) == reservation.getId()) {
                     customer.getReservations().remove(reservation);
                     break;
                 }
            }
        }

        if (!foundReservationToDelete) {
            System.out.println(Config.RED_COLOUR + "Can't find your reservation ith such ID." + Config.RESET_COLOUR);
            customer.getToMenu();
        }
        customer.getToMenu();
    }
}


