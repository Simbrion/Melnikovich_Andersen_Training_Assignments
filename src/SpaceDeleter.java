import java.io.IOException;

public class SpaceDeleter {

    public void start() throws IOException {

        if (Main.spacesList.isEmpty()) System.out.println(Config.NO_EXISTING_SPACES);
        else {
            System.out.println("Please provide a name of the space to be deleted." +
                            "\nExisting reservations related to the space (if any) will be deleted as well.");
            new SpaceListViewer().printList();
            String userInput = Main.reader.readLine();
            deleteSpaceReservations(userInput);
            if (!deleteSpace(userInput)) System.out.println(Config.NO_SPACE_WITH_NAME);
        }
    }

    //Deletes reservations related to the space
    private void deleteSpaceReservations(String userInput) {
        for (int i = 0; i < Main.reservationsList.size(); i++) {
            if (Main.reservationsList.get(i).getSpace().getName().equalsIgnoreCase(userInput)) {
                Main.reservationsList.remove(Main.reservationsList.get(i));
                i--;
            }
        }
    }

    //Searched and deletes space, returns true if a space has been successfully deleted
    private boolean deleteSpace(String userInput){
        boolean spaceIsOnTheList = false;
        for (int i = 0; i < Main.spacesList.size(); i++) {
            if (Main.spacesList.get(i).getName().equalsIgnoreCase(userInput)) {
                String deletedSpaceName = Main.spacesList.get(i).getName();
                Main.spacesList.remove(Main.spacesList.get(i));
                spaceIsOnTheList = true;
                System.out.println(Config.GREEN_COLOUR + "The space named " + deletedSpaceName + " and all related reservations (if any) have been successfully deleted!" + Config.RESET_COLOUR);
                i--;
            }
        }
        return spaceIsOnTheList;
    }
}
