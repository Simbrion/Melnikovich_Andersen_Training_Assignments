import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class InputValidator {

    public boolean isPositiveInt(String userInput) {
        char[] userInputAsChars = userInput.toCharArray();
        for (char a : userInputAsChars) {
            if (!Character.isDigit(a)) return false;
        }
        return Integer.parseInt(userInput) >= 0;
    }

    public boolean isDate(String userInput) {
        try {
            LocalDate.parse(userInput);
            return true;
        }
        catch (DateTimeParseException e) {
            return false;
        }
    }

    public boolean isTime(String userInput) {
        try {
            LocalTime.parse(userInput);
            return true;
        }
        catch (DateTimeParseException e) {
            return false;
        }
    }

}
