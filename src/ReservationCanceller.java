import java.io.IOException;

public class ReservationCanceller {

    public void cancelReservation(Customer customer) throws IOException {

        if (Main.reservationsList.isEmpty()) {
            System.out.println(Config.NO_EXISTING_RESERVATIONS);
            customer.getToMenu();
        }

        try {
            System.out.println("Please indicate ID of the reservation to be cancelled.");
            new ReservationsListViewer().printCustomerReservationsList(customer.getName());
            String userInput = Main.reader.readLine();
            if (Main.inputValidator.isPositiveInt(userInput)) {
                checkAndDelete(userInput, customer);
            } else {
                System.out.println(Config.WRONG_INPUT_MESSAGE);
                customer.getToMenu();
            }
        } catch (Exception e) {
            System.out.println(Config.WRONG_INPUT_EXCEPTION);
        }
    }

    private void checkAndDelete(String userInput, Customer customer) throws IOException {
        boolean reservationDeleted = false;
        for (int i = 0; i < Main.reservationsList.size(); i++) {
            if ((Integer.parseInt(userInput) == Main.reservationsList.get(i).getId()) && (Main.reservationsList.get(i).getCustomerName().equalsIgnoreCase(customer.getName()))) {
                Main.reservationsList.remove(Main.reservationsList.get(i));
                System.out.println(Config.GREEN_COLOUR + "Reservation has been successfully deleted!" + Config.RESET_COLOUR);
                reservationDeleted = true;
                customer.getToMenu();
            }
            if (!reservationDeleted)
                System.out.println(Config.RED_COLOUR + "Can't find your reservation ith such ID." + Config.RESET_COLOUR);
            customer.getToMenu();
        }
    }

}
