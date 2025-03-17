package DataTypesAndOperations.SpaceOperators;

import java.io.IOException;

import DataTypesAndOperations.DataTypes.Space;
import MainPackage.*;

public class SpaceTypeModifier {

    public void modifyType(Space space) throws IOException {

        while (true) {
            System.out.println(Config.YELLOW_COLOUR +
                               """
                               Do you want to change the type of the selected space?
                                 1. Yes
                                 2. No
                               """ + Config.RESET_COLOUR);
            String userInput = Main.READER.readLine();
            if (userInput.equals("1")) {
                Main.SPACE_TYPE_SELECTOR.selectType(space);
                break;
            }
            else if (userInput.equals("2")) {
                break;
            }
            else {
                System.out.println(Config.WRONG_INPUT_MESSAGE);
            }
        }
    }

}
