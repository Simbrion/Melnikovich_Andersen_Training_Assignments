package DataTypesAndOperations.CustomerOperations;

import DataTypesAndOperations.DataTypes.Customer;
import DataTypesAndOperations.DataTypes.Reservation;
import MainPackage.*;
import MainPackage.Config;

import java.io.IOException;
import java.util.List;

public class CustomerDeleter {

    public void start() throws IOException {

        if (Main.CUSTOMERS_DATABASE.isEmpty()) System.out.println(Config.NO_EXISTING_CUSTOMERS);
        else {
            System.out.println(Config.YELLOW_COLOUR + "Please provide a name of the customer to be deleted." +
                    "\nExisting reservations related to the customer (if any) will be deleted as well." + Config.RESET_COLOUR);
            Main.CUSTOMER_LIST_VIEWER.printList();
            String userInput = Main.READER.readLine();
            deleteCustomerReservations(userInput);
            if (!deleteCustomer(userInput)) System.out.println(Config.NO_CUSTOMER_WITH_NAME);
        }
    }

    //Deletes reservations related to the customer, if any
    private void deleteCustomerReservations(String userInput) {
        List<Reservation> currentReservationsList = Main.RESERVATIONS_DATABASE.getData();

        for (int i = 0; i < currentReservationsList.size(); i++) {
            if (currentReservationsList.get(i).getCustomerName().equalsIgnoreCase(userInput)) {
                Main.RESERVATIONS_DATABASE.removeReservation(currentReservationsList.get(i));
                currentReservationsList.remove(currentReservationsList.get(i));
                i--;
            }
        }
    }

    //Searched and deletes customer, returns true if a customer has been successfully deleted
    private boolean deleteCustomer(String userInput){
        boolean customerIsOnTheList = false;
        List<Customer> currentCustomersList = Main.CUSTOMERS_DATABASE.getData();
        for (int i = 0; i < currentCustomersList.size(); i++) {
            if (currentCustomersList.get(i).getName().equalsIgnoreCase(userInput)) {
                String deletedCustomerName = currentCustomersList.get(i).getName();
                Main.CUSTOMERS_DATABASE.removeCustomer(currentCustomersList.get(i));
                currentCustomersList.remove(currentCustomersList.get(i));
                customerIsOnTheList = true;
                System.out.println(Config.GREEN_COLOUR + "The customer named " + deletedCustomerName + " and all related reservations (if any) have been successfully deleted!" + Config.RESET_COLOUR);
                i--;
            }
        }
        return customerIsOnTheList;
    }


}

