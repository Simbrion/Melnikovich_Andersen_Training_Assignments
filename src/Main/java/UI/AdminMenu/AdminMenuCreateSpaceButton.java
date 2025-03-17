package UI.AdminMenu;

import DataTypesAndOperations.DataTypes.Customer;
import MainPackage.*;
import UI.*;

import java.io.IOException;

public class AdminMenuCreateSpaceButton implements MenuButton {
    private String buttonText = "Create a new space";

    @Override
    public void onPush() throws IOException {
        Main.SPACE_CREATOR.start();
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
