import java.io.IOException;

public class CustMenuButtonShowReserv implements MenuButton {
    private String buttonText = "Show available reservations";

    @Override
    public void onPush() {
    }

    @Override
    public void onPush(Customer customer) throws IOException {
        Main.reservationListViewer.printCustomerReservationsList(customer.getName());
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
