import java.io.IOException;

public class ReservationSpaceSelector {

    public void select(Reservation newReservation) throws IOException {

        while (true) {

            if (Main.spacesList.isEmpty()) {
                System.out.println(Config.NO_EXISTING_SPACES);
                break;
            }

            boolean spaceNameIsOnTheList = false;
            System.out.println("Please insert the name of the space to be reserved.");
            new SpaceListViewer().printList();
            String userInput = Main.reader.readLine();
            for (Space space : Main.spacesList) {
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
