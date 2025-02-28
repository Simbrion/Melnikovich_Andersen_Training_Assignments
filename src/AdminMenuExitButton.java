import java.io.IOException;

public class AdminMenuExitButton implements MenuButton {
    private String buttonText = "Exit";

    @Override
    public void onPush() throws IOException {
        System.out.println(Config.EXIT_MESSAGE);
        System.exit(0);
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
