package UI.AdminMenu;

import DataTypesAndOperations.DataTypes.Customer;
import MainPackage.Main;
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
