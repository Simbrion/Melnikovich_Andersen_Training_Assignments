package UI.CustomerMenu;

import java.io.IOException;

import DataTypesAndOperations.DataTypes.Customer;
import MainPackage.*;
import UI.*;


public class CustMenuCancelReservButton implements MenuButton {
    private String buttonText = "Cancel my reservation";

    @Override
    public void onPush() {}

    @Override
    public void onPush(Customer customer) throws IOException {
        Main.RESERV_CANCELLER.cancelReservation(customer);
        Main.CUSTOMER_MENU.getToMenu(customer);
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
