import java.io.IOException;

public class MainMenuLoginCustButton implements MenuButton {
    private String buttonText = "Customer";

    @Override
    public void onPush() throws IOException {
        Main.login.logIn();
    }

    @Override
    public void onPush(Customer customer) throws IOException {
    }

    @Override
    public void show() {
        Main.buttonShower.showButton(this, Main.mainMenuButtons);
    }

    @Override
    public String getText() {
        return buttonText;
    }
}
