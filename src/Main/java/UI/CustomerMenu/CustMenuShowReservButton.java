package UI.CustomerMenu;

import java.io.IOException;

import DataTypesAndOperations.DataTypes.Customer;
import MainPackage.*;
import UI.*;


public class CustMenuShowReservButton implements MenuButton {
    private String buttonText = "Show my reservations";

    @Override
    public void onPush() {
    }

    @Override
    public void onPush(Customer customer) throws IOException {
        Main.RESERV_LIST_VIEWER.printCustomerReservationsList(customer);
        customer.getToMenu();
    }

    @Override
    public void show() {
        Main.BUTTON_SHOWER.showButton(this, Main.CUST_MENU_BUTTONS);
    }

    @Override
    public String getText() {
        return buttonText;
    }
}
