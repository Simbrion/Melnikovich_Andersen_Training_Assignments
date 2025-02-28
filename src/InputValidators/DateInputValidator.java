package InputValidators;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateInputValidator implements ValidationOperation {

    public boolean validate(String userInput) {
        try {
            LocalDate.parse(userInput);
            return true;
        }
        catch (DateTimeParseException e) {
            return false;
        }
    }

}
