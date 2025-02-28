import java.io.IOException;

public class SpaceDeleter {

    public void start() throws IOException {

        if (Main.SPACES.isEmpty()) System.out.println(Config.NO_EXISTING_SPACES);
        else {
            System.out.println(Config.YELLOW_COLOUR + "Please provide a name of the space to be deleted." +
                            "\nExisting reservations related to the space (if any) will be deleted as well." + Config.RESET_COLOUR);
            Main.SPACE_LIST_VIEWER.printList();
            String userInput = Main.READER.readLine();
            deleteSpaceReservations(userInput);
            deleteCustomersReservations(userInput);
            if (!deleteSpace(userInput)) System.out.println(Config.NO_SPACE_WITH_NAME);
        }
    }

    //Deletes reservations related to the space
    private void deleteSpaceReservations(String userInput) {
        for (int i = 0; i < Main.RESERVATIONS.size(); i++) {
            if (Main.RESERVATIONS.get(i).getSpace().getName().equalsIgnoreCase(userInput)) {
                Main.RESERVATIONS.remove(Main.RESERVATIONS.get(i));
                i--;
            }
        }
    }

    //Deletes related reservations from each customer
    private void deleteCustomersReservations(String userInput) {
        for (Customer customer : Main.CUSTOMERS) {
            for (int i = 0; i < customer.getReservations().size(); i++) {
                if (customer.getReservations().get(i).getSpace().getName().equalsIgnoreCase(userInput)) {
                    customer.getReservations().remove(customer.getReservations().get(i));
                    break;
                }
            }
        }
    }

    //Searched and deletes space, returns true if a space has been successfully deleted
    private boolean deleteSpace(String userInput){
        boolean spaceIsOnTheList = false;
        for (int i = 0; i < Main.SPACES.size(); i++) {
            if (Main.SPACES.get(i).getName().equalsIgnoreCase(userInput)) {
                String deletedSpaceName = Main.SPACES.get(i).getName();
                Main.SPACES.remove(Main.SPACES.get(i));
                spaceIsOnTheList = true;
                System.out.println(Config.GREEN_COLOUR + "The space named " + deletedSpaceName + " and all related reservations (if any) have been successfully deleted!" + Config.RESET_COLOUR);
                i--;
            }
        }
        return spaceIsOnTheList;
    }
}

