public class ReservationsListViewer implements ListViewer {

    public void printList() {
        if (Main.reservationsList.isEmpty()) System.out.println(Config.NO_EXISTING_RESERVATIONS);
        else {
            System.out.println(Config.YELLOW_COLOUR + "There are the following reservations registered in the system:" + Config.RESET_COLOUR);
            int numberOfAllReservations = 0;
            for (Reservation reservation : Main.reservationsList) {
                numberOfAllReservations++;
                reservation.printDescription();
            }
            System.out.println(Config.YELLOW_COLOUR + numberOfAllReservations +" reservations in total." + Config.RESET_COLOUR);
        }
    }

    public void printCustomerReservationsList(String customerName) {
        if (Main.reservationsList.isEmpty()) System.out.println(Config.YELLOW_COLOUR + "There are no reservations for name " + customerName + "." + Config.RESET_COLOUR);
        else {
            System.out.println(Config.YELLOW_COLOUR + "You have the following reservations:" + Config.RESET_COLOUR);
            int numberOfUserReservations = 0;
            for (Reservation reservation : Main.reservationsList) {
                if (reservation.getCustomerName().equalsIgnoreCase(customerName)) {
                    reservation.printDescription();
                    numberOfUserReservations++;
                }
            }
            System.out.println(Config.YELLOW_COLOUR + numberOfUserReservations +" reservations in total." + Config.RESET_COLOUR);
        }
    }
}

