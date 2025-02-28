import java.io.IOException;

public class AdminMenuBackToLoginButton implements MenuButton {
    private String buttonText = "Back to login menu";

    @Override
    public void onPush() throws IOException {
        Main.session.getToMenu();
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
