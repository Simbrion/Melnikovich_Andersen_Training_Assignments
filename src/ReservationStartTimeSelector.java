import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ReservationStartTimeSelector {

    public void select(Reservation newReservation) throws IOException {
        while (true) {
            System.out.println("Please insert the reservation start time of the reservation in HH:mm format.");
            String userInput = Main.reader.readLine();
            if (Main.inputValidator.validate(Main.timeInputValidator, userInput)) {
                try {
                LocalDateTime startOfNewReservation = LocalDateTime.of(newReservation.getDate(), LocalTime.parse(userInput));
                if (Main.timeOverlapChecker.startTimeOverlaps(startOfNewReservation, newReservation)) {
                    System.out.println(Config.RED_COLOUR + "The reservation start time overlaps with the existing reservation. Please choose different start time." + Config.RESET_COLOUR);
                    continue;
                }
                newReservation.setStartTime(LocalTime.parse(userInput));
                break;
                }
                catch (Exception e) {
                System.out.println(Config.WRONG_INPUT_EXCEPTION);
                }
            }
            else System.out.println(Config.WRONG_INPUT_MESSAGE);
        }
    }
}
