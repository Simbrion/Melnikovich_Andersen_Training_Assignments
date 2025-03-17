package DataTypesAndOperations.SpaceOperators;

import java.io.IOException;

import DataTypesAndOperations.DataTypes.Space;
import MainPackage.*;

public class SpacePriceSelector {

    public void start(Space space) throws IOException {
        System.out.println(Config.YELLOW_COLOUR + "Please indicate the price of the space " + space.getName() + " (USD per hour)." + Config.RESET_COLOUR);
        String userInput = Main.READER.readLine();
        try {
            if (Main.INPUT_VALIDATOR.validate(Main.POSITIVE_DIGIT_VALIDATOR, userInput)) {
                space.setPrice(Integer.parseInt(userInput));
            }
            else {
                System.out.println(Config.WRONG_INPUT_MESSAGE);
                this.start(space);
            }
        } catch (NumberFormatException e) {
            System.out.println(Config.WRONG_INPUT_EXCEPTION);
        }
    }


}
