import java.io.IOException;

public class MenuInputValidator {

    public void validate(Menu menu, String userInput) throws IOException {

        if (!Main.INPUT_VALIDATOR.validate(Main.POSITIVE_DIGIT_VALIDATOR, userInput)) {
            System.out.println(Config.WRONG_INPUT_MESSAGE);
            menu.getToMenu();
        }

        if (!menu.getMenuOptionNumbers().contains(Integer.parseInt(userInput))) {
            System.out.println(Config.WRONG_INPUT_MESSAGE);
            menu.getToMenu();
        }
    }

}
