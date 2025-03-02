package UtilityServices.UserInputValidators;

public class InputValidator  {

    public boolean validate(ValidationOperation validationType, String userInput) {

        return validationType.validate(userInput);

    }

}
