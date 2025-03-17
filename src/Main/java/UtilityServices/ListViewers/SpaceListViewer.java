package UtilityServices.ListViewers;

import DataTypesAndOperations.DataTypes.Space;
import MainPackage.*;

public class SpaceListViewer implements ListViewer {

    public void printList () {
        if (Main.SPACES.isEmpty()) System.out.println(Config.NO_EXISTING_SPACES);
        else {
            System.out.println(Config.YELLOW_COLOUR + "The following spaces are registered in the system:" + Config.RESET_COLOUR);
            for (Space space : Main.SPACES) space.printDescription();
        }
    }
}
