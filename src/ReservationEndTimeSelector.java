import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ReservationEndTimeSelector {

    public void selectEndTime (Reservation newReservation) throws IOException {

        while (true) {
            System.out.println(Config.YELLOW_COLOUR + "Please insert the end time of the reservation in HH:mm format." + Config.RESET_COLOUR);
            String userInput = Main.READER.readLine();
            if (Main.INPUT_VALIDATOR.validate(Main.TIME_INPUT_VALIDATOR, userInput)) {
                try {
                    if (endTimeBeforeStart(newReservation, userInput) || timeSlotOverlaps(newReservation, userInput)) continue;
                    newReservation.setEndTime(LocalTime.parse(userInput));
                    break;
                } catch (Exception e) {
                    System.out.println(Config.WRONG_INPUT_EXCEPTION);
                }
            }
            else System.out.println(Config.WRONG_INPUT_MESSAGE);
        }
    }

    private boolean endTimeBeforeStart(Reservation newReservation, String userInput) {
        if (newReservation.getStartTime().isAfter(LocalTime.parse(userInput))) {
            System.out.println(Config.RED_COLOUR + "The end time should be after the start time. Please choose different start time." + Config.RESET_COLOUR);
            return true;
        }
        else return false;
    }

    private boolean timeSlotOverlaps(Reservation newReservation, String userInput) {
        LocalDateTime endOfNewReservation = LocalDateTime.of(newReservation.getDate(), LocalTime.parse(userInput));
        if (Main.TIME_OVERLAP_CHECKER.endTimeOverlaps(endOfNewReservation, newReservation)) {
            System.out.println(Config.RED_COLOUR + "The reservation slot overlaps with the existing reservation. Please choose different end time." + Config.RESET_COLOUR);
            return true;
        }
        else return false;
    }
}
