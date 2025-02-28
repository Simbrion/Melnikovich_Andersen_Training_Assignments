import java.io.IOException;

public class SpacePriceSelector {

    public void selectPrice(Space space) throws IOException {
        System.out.println(Config.YELLOW_COLOUR + "Please indicate the price of the space " + space.getName() + " (USD per hour)." + Config.RESET_COLOUR);
        String userInput = Main.READER.readLine();
        try {
            if (Main.INPUT_VALIDATOR.validate(Main.POSITIVE_DIGIT_VALIDATOR, userInput)) {
                space.setPrice(Integer.parseInt(userInput));
            }
            else {
                System.out.println(Config.WRONG_INPUT_MESSAGE);
                this.selectPrice(space);
            }
        } catch (NumberFormatException e) {
            System.out.println(Config.WRONG_INPUT_EXCEPTION);
        }
    }


}
