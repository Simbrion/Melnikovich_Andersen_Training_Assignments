import java.io.IOException;

public class AdminMenuCreateSpaceButton implements MenuButton {
    private String buttonText = "Create a new space";

    @Override
    public void onPush() throws IOException {
        Main.spaceCreator.start();
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
