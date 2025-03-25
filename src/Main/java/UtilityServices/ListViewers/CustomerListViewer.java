package UtilityServices.ListViewers;

import DataTypesAndOperations.DataTypes.Customer;
import MainPackage.*;


public class CustomerListViewer implements ListViewer {

    public void printList() {

            if (Main.CUSTOMERS_DATABASE.isEmpty()) {
                System.out.println(Config.NO_EXISTING_CUSTOMERS);
            }
            else {
                System.out.println(Config.YELLOW_COLOUR + "The following customers are registered in the system:" + Config.RESET_COLOUR);
                for (Customer customer : Main.CUSTOMERS_DATABASE.getData()) {
                    System.out.println(Config.YELLOW_COLOUR + " -" + customer.getName() + Config.RESET_COLOUR);
                }
            }
    }
}
