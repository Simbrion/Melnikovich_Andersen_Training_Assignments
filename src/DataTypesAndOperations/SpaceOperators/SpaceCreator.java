package DataTypesAndOperations.SpaceOperators;

import java.io.IOException;

import DataTypesAndOperations.DataTypes.Space;
import Main.*;

public class SpaceCreator {

    public void start() throws IOException {
        boolean newSpaceNameIsOriginal = true;

        System.out.println(Config.YELLOW_COLOUR + "Please provide a name for the new space." + Config.RESET_COLOUR);
        String userInput = Main.READER.readLine();

        boolean inputIsValid = Main.INPUT_VALIDATOR.validate(Main.CHARS_OR_DIGITS_INPUT_VALIDATOR, userInput);

        if (!inputIsValid) {
            System.out.println(Config.EMPTY_INPUT);
            start();
        }

        for (Space space : Main.SPACES) {
            if (userInput.equalsIgnoreCase(space.getName())) {
                System.out.println(Config.RED_COLOUR + "Space with this name already exists. Please choose another name." + Config.RESET_COLOUR);
                newSpaceNameIsOriginal = false;
                Main.ADMIN.getToMenu();
            }
        }

        if (newSpaceNameIsOriginal && inputIsValid) {
            Space newSpace = new Space();
            newSpace.initialize(userInput);
            Main.SPACES.add(newSpace);
            System.out.println(Config.GREEN_COLOUR + "A new space has been created!" + Config.RESET_COLOUR);
            newSpace.printDescription();
        }
    }

}
