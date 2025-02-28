import java.io.IOException;

public class SpacePriceModifier {

    public void modifyPrice(Space space) throws IOException {
        System.out.println("Please provide a new price for the space " + space.getName() +
                    ". Insert \"N\" if you do not want to change the price.");
        String userInput = Main.reader.readLine();
        try {
            if (Main.inputValidator.validate(Main.positiveDigitValidator, userInput)) space.setPrice(Integer.parseInt(userInput));
            else if (userInput.equalsIgnoreCase("n"));
            else {
                System.out.println(Config.WRONG_INPUT_MESSAGE);
                this.modifyPrice(space);
            }
        } catch (NumberFormatException e) {
            System.out.println(Config.WRONG_INPUT_EXCEPTION);
        }
    }
}
