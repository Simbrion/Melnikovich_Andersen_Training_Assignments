package UI.AdminMenu;

import DataTypesAndOperations.DataTypes.Customer;
import Main.*;
import UI.*;

import java.io.IOException;

public class AdminMenuBackToLoginButton implements MenuButton {
    private String buttonText = "Back to login menu";

    @Override
    public void onPush() throws IOException {
        Main.SESSION.getToMenu();
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
