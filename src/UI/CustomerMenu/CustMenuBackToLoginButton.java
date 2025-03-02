package UI.CustomerMenu;

import java.io.IOException;

import DataTypesAndOperations.DataTypes.Customer;
import Main.*;
import UI.*;

public class CustMenuBackToLoginButton implements MenuButton {
    private String buttonText = "Back to login menu";

    public void onPush(){};

    @Override
    public void onPush(Customer customer) throws IOException {
        Main.SESSION.getToMenu();
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
