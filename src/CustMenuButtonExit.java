import java.io.IOException;

public class CustMenuButtonExit implements MenuButton {
    private String buttonText = "Exit the application";

    @Override
    public void onPush() {}

    @Override
    public void onPush(Customer customer) throws IOException {
        System.out.println(Config.EXIT_MESSAGE);
        System.exit(0);
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
