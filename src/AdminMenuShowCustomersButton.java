import java.io.IOException;

public class AdminMenuShowCustomersButton implements MenuButton {
    private String buttonText = "Show all registered clients";

    @Override
    public void onPush() throws IOException {
        Main.customerListViewer.printList();
        Main.admin.getToMenu();
    }

    @Override
    public void onPush(Customer customer) throws IOException {

    }

    @Override
    public void show() {
        Main.buttonShower.showButton(this, Main.adminMenuButtons);
    }

    @Override
    public String getText() {
        return buttonText;
    }
}
