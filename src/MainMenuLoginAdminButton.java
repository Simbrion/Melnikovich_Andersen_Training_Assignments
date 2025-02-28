import java.io.IOException;

public class MainMenuLoginAdminButton implements MenuButton {
    private String buttonText = "Administrator";

    @Override
    public void onPush() throws IOException {
        Main.admin.getToMenu();
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
