import java.io.IOException;

public class CustMenuButtonCancelReserv implements MenuButton {
    private String buttonText = "Cancel my reservation";

    @Override
    public void onPush() {}

    @Override
    public void onPush(Customer customer) throws IOException {

        Main.reservationCanceller.cancelReservation(customer);
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
