package DataTypesAndOperations.CustomerOperations;

import Main.Main;
import Main.Config;

import java.io.IOException;

public class CustomerDeleter {

    public void start() throws IOException {

        if (Main.CUSTOMERS.isEmpty()) System.out.println(Config.NO_EXISTING_CUSTOMERS);
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
        for (int i = 0; i < Main.RESERVATIONS.size(); i++) {
            if (Main.RESERVATIONS.get(i).getCustomerName().equalsIgnoreCase(userInput)) {
                Main.DATA_DELETER.deleteReservationData(Main.RESERVATIONS.get(i));
                Main.RESERVATIONS.remove(Main.RESERVATIONS.get(i));
                i--;
            }
        }
    }

    //Searched and deletes customer, returns true if a customer has been successfully deleted
    private boolean deleteCustomer(String userInput){
        boolean customerIsOnTheList = false;
        for (int i = 0; i < Main.CUSTOMERS.size(); i++) {
            if (Main.CUSTOMERS.get(i).getName().equalsIgnoreCase(userInput)) {
                String deletedCustomerName = Main.CUSTOMERS.get(i).getName();
                Main.DATA_DELETER.deleteCustomerData(Main.CUSTOMERS.get(i));
                Main.CUSTOMERS.remove(Main.CUSTOMERS.get(i));
                customerIsOnTheList = true;
                System.out.println(Config.GREEN_COLOUR + "The customer named " + deletedCustomerName + " and all related reservations (if any) have been successfully deleted!" + Config.RESET_COLOUR);
                i--;
            }
        }
        return customerIsOnTheList;
    }


}

