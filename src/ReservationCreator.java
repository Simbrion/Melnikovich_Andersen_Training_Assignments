import java.io.IOException;

public class ReservationCreator {
    public static int reservIdCount = 1;

    public void createReservation(Customer customer) throws IOException {

        if (Main.SPACES.isEmpty()) {
            System.out.println(Config.NO_EXISTING_SPACES);
        }

        else {
            Reservation newReservation = new Reservation();
            Main.RESERV_SPACE_SELECTOR.select(newReservation);
            if (newReservation.getSpace() != null) Main.RESERV_DATE_SELECTOR.selectDate(newReservation);
            if (newReservation.getDate() != null) Main.RESERV_START_TIME_SELECTOR.select(newReservation);
            if (newReservation.getStartTime() != null) Main.RESERV_END_TIME_SELECTOR.selectEndTime(newReservation);

            if (reservationIsReady(newReservation)) {
                newReservation.setId(reservIdCount++);
                newReservation.setCustomer(customer);
                Main.RESERVATIONS.add(newReservation);
                customer.addReservation(newReservation);
                System.out.println(Config.GREEN_COLOUR + "Reservation has been added!" + Config.RESET_COLOUR);
                newReservation.printDescription();
            } else
                System.out.println(Config.RED_COLOUR + "Reservation creation failed, please try again." + Config.RESET_COLOUR);
        }
    }

    private boolean reservationIsReady(Reservation reservation) {
        if (reservation.getEndTime()!=null
         && reservation.getSpace()!=null
         && reservation.getDate()!=null
         && reservation.getStartTime()!=null)
            return true;
        else return false;
    }

}

