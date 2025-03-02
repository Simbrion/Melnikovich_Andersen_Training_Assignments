package DataTypesAndOperations.ReservationOperators;

import DataTypesAndOperations.DataTypes.Reservation;
import DataTypesAndOperations.DataTypes.Space;
import Main.*;
import UtilityServices.ListViewers.SpaceListViewer;

import java.io.IOException;

public class ReservationSpaceSelector {

    public void select(Reservation newReservation) throws IOException {

        while (true) {

            boolean spaceNameIsOnTheList = false;
            System.out.println(Config.YELLOW_COLOUR + "Please insert the name of the space to be reserved." + Config.RESET_COLOUR);
            new SpaceListViewer().printList();
            String userInput = Main.READER.readLine();
            for (Space space : Main.SPACES) {
                if (userInput.equalsIgnoreCase(space.getName())) {
                    newReservation.setSpace(space);
                    spaceNameIsOnTheList = true;
                    break;
                }
            }

            if (!spaceNameIsOnTheList) {
                System.out.println(Config.NO_SPACE_WITH_NAME);
            }
            else break;
        }
    }
}
