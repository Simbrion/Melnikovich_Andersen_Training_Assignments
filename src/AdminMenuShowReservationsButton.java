import java.io.IOException;

public class AdminMenuShowReservationsButton implements MenuButton {
    private String buttonText = "Show all registered reservations";

    @Override
    public void onPush() throws IOException {
        Main.reservationListViewer.printList();
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
