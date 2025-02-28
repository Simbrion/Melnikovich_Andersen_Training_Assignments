package InputValidators;

public class PositiveDigitValidator implements ValidationOperation {

    @Override
    public boolean validate(String userInput) {
        char[] userInputAsChars = userInput.toCharArray();
        for (char a : userInputAsChars) {
            if (!Character.isDigit(a)) return false;
        }
        try {
            return Integer.parseInt(userInput) >= 0;
        }
        catch (NumberFormatException a ){
            System.out.println("!!!");
            return false;
        }
    }
}
