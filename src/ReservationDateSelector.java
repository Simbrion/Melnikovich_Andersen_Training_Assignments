import java.io.IOException;
import java.time.LocalDate;

public class ReservationDateSelector {


    public void selectDate (Reservation reservation) throws IOException {

        while (true) {
            System.out.println("Please insert the date of the reservation in YYYY-MM-DD format.");
            String userInput = Main.reader.readLine();
            try {
                if (Main.inputValidator.isDate(userInput)) {
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
