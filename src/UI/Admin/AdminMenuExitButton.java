package UI.Admin;

import java.io.IOException;

import DataTypesAndOperations.DataTypes.Customer;
import Main.*;
import UI.*;


public class AdminMenuExitButton implements MenuButton {
    private String buttonText = "Exit";

    @Override
    public void onPush() throws IOException {
        Main.DATA_SAVER.saveSessionData();
        System.out.println(Config.EXIT_MESSAGE);
        System.exit(0);
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
