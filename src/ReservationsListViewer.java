public class ReservationsListViewer implements ListViewer {

    public void printList() {
        if (Main.RESERVATIONS.isEmpty()) System.out.println(Config.NO_EXISTING_RESERVATIONS);
        else {
            System.out.println(Config.YELLOW_COLOUR + "The following reservations are registered in the system:" + Config.RESET_COLOUR);
            int numberOfAllReservations = 0;
            for (Reservation reservation : Main.RESERVATIONS) {
                numberOfAllReservations++;
                reservation.printDescription();
            }
            System.out.println(Config.YELLOW_COLOUR + numberOfAllReservations +" reservations in total." + Config.RESET_COLOUR);
        }
    }

    public void printCustomerReservationsList(Customer customer) {
        if (Main.RESERVATIONS.isEmpty()) System.out.println(Config.YELLOW_COLOUR + "There are no reservations for name " + customer.getName() + "." + Config.RESET_COLOUR);
        else {
            System.out.println(Config.YELLOW_COLOUR + "You have the following reservations:" + Config.RESET_COLOUR);
            int numberOfUserReservations = 0;
            for (Reservation reservation : customer.getReservations()) {
                    reservation.printDescription();
                    numberOfUserReservations++;
            }
            System.out.println(Config.YELLOW_COLOUR + numberOfUserReservations +" reservations in total." + Config.RESET_COLOUR);
        }
    }
}

