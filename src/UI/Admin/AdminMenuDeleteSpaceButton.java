package UI.Admin;

import java.io.IOException;

import DataTypesAndOperations.DataTypes.Customer;
import Main.*;
import UI.*;


public class AdminMenuDeleteSpaceButton implements MenuButton {
    private String buttonText = "Delete an existing new space";

    @Override
    public void onPush() throws IOException {
        Main.SPACE_DELETER.start();
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
