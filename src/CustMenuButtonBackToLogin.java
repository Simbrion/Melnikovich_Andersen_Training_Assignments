import java.io.IOException;

public class CustMenuButtonBackToLogin implements MenuButton {
    private String buttonText = "Back to login menu";

    public void onPush(){};

    @Override
    public void onPush(Customer customer) throws IOException {
        Main.session.getToMenu();
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
