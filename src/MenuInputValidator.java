import java.io.IOException;
import java.util.HashSet;

public class MenuInputValidator {

    public void checkMenuInput(Menu menu, String userInput) throws IOException {

        if (!Main.inputValidator.validate(Main.positiveDigitValidator, userInput)) {
            System.out.println(Config.WRONG_INPUT_MESSAGE);
            menu.getToMenu();
        }

        if (!menu.getNumbersOfOptions().contains(Integer.parseInt(userInput))) {
            System.out.println(Config.WRONG_INPUT_MESSAGE);
            menu.getToMenu();
        }
    }

}
