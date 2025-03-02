package UI.AdminMenu;

import java.io.IOException;

import DataTypesAndOperations.DataTypes.Customer;
import Main.*;
import UI.*;


public class AdminMenuShowReservationsButton implements MenuButton {
    private String buttonText = "Show all registered reservations";

    @Override
    public void onPush() throws IOException {
        Main.RESERV_LIST_VIEWER.printList();
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
