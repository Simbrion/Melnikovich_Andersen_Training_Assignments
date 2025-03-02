package UI.Admin;

import DataTypesAndOperations.DataTypes.Customer;
import Main.Main;
import UI.MenuButton;

import java.io.IOException;


public class AdminMenuDeleteCustomerButton implements MenuButton {
    private String buttonText = "Delete an existing customer";

    @Override
    public void onPush() throws IOException {
        Main.CUSTOMER_DELETER.start();
        Main.ADMIN.getToMenu();
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
