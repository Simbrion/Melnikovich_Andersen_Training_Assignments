import java.io.IOException;

public class CustMenuButtonShowSpaces implements MenuButton {
    String buttonText = "Show available spaces";

    @Override
    public void onPush() {}

    @Override
    public void onPush(Customer customer) throws IOException {

        Main.spaceListViewer.printList();
        customer.getToMenu();
    }

    @Override
    public void show() {
        Main.buttonShower.showButton(this, Main.custMenuButtons);
    }

    @Override
    public String getText() {
        return buttonText;
    }
}
