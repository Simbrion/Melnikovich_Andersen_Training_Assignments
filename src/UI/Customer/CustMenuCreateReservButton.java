package UI.Customer;

import java.io.IOException;

import DataTypesAndOperations.DataTypes.Customer;
import Main.*;
import UI.*;


public class CustMenuCreateReservButton implements MenuButton {
    private String buttonText = "Make a new reservation";

    @Override
    public void onPush() {}

    @Override
    public void onPush(Customer customer) throws IOException {
        Main.RESERV_CREATOR.createReservation(customer);
        customer.getToMenu();
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
