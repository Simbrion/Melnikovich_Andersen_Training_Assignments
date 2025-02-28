import java.io.IOException;

public class SpacePriceModifier {

    public void modifyPrice(Space space) throws IOException {
        System.out.println(Config.YELLOW_COLOUR + "Please provide a new price for the space " + space.getName() +
                    ". Insert \"N\" if you do not want to change the price." + Config.RESET_COLOUR);
        String userInput = Main.READER.readLine();
        try {
            if (Main.INPUT_VALIDATOR.validate(Main.POSITIVE_DIGIT_VALIDATOR, userInput)) space.setPrice(Integer.parseInt(userInput));
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
