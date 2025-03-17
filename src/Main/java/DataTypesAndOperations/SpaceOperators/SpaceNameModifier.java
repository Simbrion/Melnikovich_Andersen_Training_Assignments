package DataTypesAndOperations.SpaceOperators;
import DataTypesAndOperations.DataTypes.Space;
import MainPackage.*;

import java.io.IOException;

public class SpaceNameModifier {

    public void start(Space space) throws IOException {
        System.out.println(Config.YELLOW_COLOUR + "Please provide a new name for the space " + space.getName() + ". Insert \"N\" if you do not want to change the name." + Config.RESET_COLOUR);
        String userInput = Main.READER.readLine();
        if (!(userInput.equalsIgnoreCase("n"))) space.setName(userInput);
    }


}
