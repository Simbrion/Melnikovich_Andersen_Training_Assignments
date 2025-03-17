package DataTypesAndOperations.ReservationOperators;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

import DataTypesAndOperations.DataTypes.Reservation;
import MainPackage.*;

public class ReservationStartTimeSelector {

    public void select(Reservation newReservation) throws IOException {
        while (true) {
            System.out.println(Config.YELLOW_COLOUR + "Please insert the reservation start time of the reservation in HH:mm format." + Config.RESET_COLOUR);
            String userInput = Main.READER.readLine();
            if (Main.INPUT_VALIDATOR.validate(Main.TIME_INPUT_VALIDATOR, userInput)) {
                try {
                LocalDateTime startOfNewReservation = LocalDateTime.of(newReservation.getDate(), LocalTime.parse(userInput));
                if (Main.TIME_OVERLAP_CHECKER.startTimeOverlaps(startOfNewReservation, newReservation)) {
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
