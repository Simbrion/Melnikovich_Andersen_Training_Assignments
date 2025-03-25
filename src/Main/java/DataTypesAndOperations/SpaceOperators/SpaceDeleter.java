package DataTypesAndOperations.SpaceOperators;
import DataTypesAndOperations.DataTypes.Reservation;
import DataTypesAndOperations.DataTypes.Space;
import MainPackage.*;
import DataTypesAndOperations.DataTypes.Customer;

import java.io.IOException;
import java.util.List;

public class SpaceDeleter {

    public void start() throws IOException {

        if (Main.SPACES_DATABASE.isEmpty()) System.out.println(Config.NO_EXISTING_SPACES);
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

    //Deletes reservations related to the space, if any
    private void deleteSpaceReservations(String userInput) {
        List<Reservation> currentReservationsList = Main.RESERVATIONS_DATABASE.getData();
        for (int i = 0; i < currentReservationsList.size(); i++) {
            if (currentReservationsList.get(i).getSpace().getName().equalsIgnoreCase(userInput)) {
                Main.RESERVATIONS_DATABASE.removeReservation(currentReservationsList.get(i));
                currentReservationsList.remove(currentReservationsList.get(i));
                i--;
            }
        }
    }

    //Deletes related reservations from each customer, if any
    private void deleteCustomersReservations(String userInput) {
        List<Customer> currentCustomersList = Main.CUSTOMERS_DATABASE.getData();
        for (Customer customer : currentCustomersList) {
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
        List<Space> currentSpaceList = Main.SPACES_DATABASE.getData();
        for (int i = 0; i < currentSpaceList.size(); i++) {
            if (currentSpaceList.get(i).getName().equalsIgnoreCase(userInput)) {
                String deletedSpaceName = currentSpaceList.get(i).getName();
                Main.SPACES_DATABASE.removeSpace(currentSpaceList.get(i));
                currentSpaceList.remove(currentSpaceList.get(i));
                spaceIsOnTheList = true;
                System.out.println(Config.GREEN_COLOUR + "The space named " + deletedSpaceName + " and all related reservations (if any) have been successfully deleted!" + Config.RESET_COLOUR);
                i--;
            }
        }
        return spaceIsOnTheList;
    }


}

