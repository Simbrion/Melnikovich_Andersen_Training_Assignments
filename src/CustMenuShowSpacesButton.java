import java.io.IOException;

public class CustMenuShowSpacesButton implements MenuButton {
    String buttonText = "Show available spaces";

    @Override
    public void onPush() {}

    @Override
    public void onPush(Customer customer) throws IOException {

        Main.SPACE_LIST_VIEWER.printList();
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
