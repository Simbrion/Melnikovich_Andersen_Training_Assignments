package DataTypesAndOperations.ReservationOperators;

import java.io.IOException;
import java.time.LocalDate;

import DataTypesAndOperations.DataTypes.Reservation;
import MainPackage.*;

public class ReservationDateSelector {


    public void selectDate (Reservation reservation) throws IOException {

        while (true) {
            System.out.println(Config.YELLOW_COLOUR + "Please insert the date of the reservation in YYYY-MM-DD format." + Config.RESET_COLOUR);
            String userInput = Main.READER.readLine();
            try {
                if (Main.INPUT_VALIDATOR.validate(Main.DATE_INPUT_VALIDATOR, userInput)) {
                    reservation.setDate(LocalDate.parse(userInput));
                    break;
                }
                else {
                    System.out.println(Config.WRONG_INPUT_MESSAGE);
                }
            } catch (Exception e) {
                System.out.println(Config.WRONG_INPUT_EXCEPTION);
            }
        }
    }
}
