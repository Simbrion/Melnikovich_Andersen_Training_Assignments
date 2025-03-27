package UI.AdminMenu;

import java.io.IOException;

import DataTypesAndOperations.DataTypes.Customer;
import MainPackage.*;
import UI.*;


public class AdminMenuShowCustomersButton implements MenuButton {
    private String buttonText = "Show all existing customers";

    @Override
    public void onPush() throws IOException {
        Main.CUSTOMER_LIST_VIEWER.printList();
        Main.ADMIN_MENU.getToMenu();
    }

    @Override
    public void onPush(Customer customer) throws IOException {

    }

    @Override
    public void show() {
        Main.BUTTON_SHOWER.showButton(this, Main.ADMIN_MENU_BUTTONS);
    }

    @Override
    public String getText() {
        return buttonText;
    }
}
