import java.io.IOException;

public class ReservationCreator {
    public static int idCount = 1;

    public void createReservation(String customerName) throws IOException {

        Reservation newReservation = new Reservation();

        new ReservationSpaceSelector().select(newReservation);
        if (newReservation.getSpace() != null) new ReservationDateSelector().selectDate(newReservation);
        if (newReservation.getDate() != null) new ReservationStartTimeSelector().select(newReservation);
        if (newReservation.getStartTime() != null) new ReservationEndTimeSelector().selectEndTime(newReservation);

        if (reservationIsReady(newReservation)) {
            newReservation.setId(idCount++);
            newReservation.setCustomerName(customerName);
            Main.reservationsList.add(newReservation);
            System.out.println(Config.GREEN_COLOUR + "Reservation has been added!" + Config.RESET_COLOUR);
            newReservation.printDescription();
        }
        else System.out.println(Config.RED_COLOUR + "Reservation creation failed, please try again." + Config.RESET_COLOUR);
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

