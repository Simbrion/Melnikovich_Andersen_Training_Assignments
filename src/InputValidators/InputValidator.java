package InputValidators;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class InputValidator  {

    public boolean validate(ValidationOperation validationType, String userInput) {

        return validationType.validate(userInput);

    }

}
