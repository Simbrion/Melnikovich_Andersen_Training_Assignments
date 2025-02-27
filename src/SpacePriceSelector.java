import java.io.IOException;

public class SpacePriceSelector {

    public void selectPrice(Space space) throws IOException {
        System.out.println("Please indicate the price of the space " + space.getName() + " (USD per hour).");
        String userInput = Main.reader.readLine();
        try {
            if (Main.inputValidator.isPositiveInt(userInput)) {
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
