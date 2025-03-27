package UI.AdminMenu;

import java.io.IOException;

import DataTypesAndOperations.DataTypes.Customer;
import MainPackage.*;
import UI.*;


public class AdminMenuUpdateSpaceButton implements MenuButton {
    private String buttonText = "Update an existing space";

    @Override
    public void onPush() throws IOException {

        if (Main.SPACES_DATABASE.isEmpty()) {
            System.out.println(Config.NO_EXISTING_SPACES);
            Main.ADMIN_MENU.getToMenu();

        }
        else {
            Main.SPACE_MODIFIER.start();
            Main.ADMIN_MENU.getToMenu();
        }

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
