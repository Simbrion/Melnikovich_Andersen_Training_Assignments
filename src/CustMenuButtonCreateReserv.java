import java.io.IOException;

public class CustMenuButtonCreateReserv implements MenuButton {
    private String buttonText = "Make a new reservation";

    @Override
    public void onPush() {}

    @Override
    public void onPush(Customer customer) throws IOException {
        Main.reservationCreator.createReservation(customer.getName());
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
