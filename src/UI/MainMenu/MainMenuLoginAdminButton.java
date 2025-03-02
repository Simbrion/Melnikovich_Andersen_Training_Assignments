package UI.MainMenu;

import DataTypesAndOperations.DataTypes.Customer;
import UI.*;
import Main.*;

import java.io.IOException;

public class MainMenuLoginAdminButton implements MenuButton {
    private String buttonText = "Administrator";

    @Override
    public void onPush() throws IOException {
        Main.ADMIN.getToMenu();
    }

    @Override
    public void onPush(Customer customer) throws IOException {
    }

    @Override
    public void show() {
        Main.BUTTON_SHOWER.showButton(this, Main.MAIN_MENU_BUTTONS);
    }

    @Override
    public String getText() {
        return buttonText;
    }
}
