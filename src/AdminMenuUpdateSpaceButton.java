import java.io.IOException;

public class AdminMenuUpdateSpaceButton implements MenuButton {
    private String buttonText = "Update an existing new space";

    @Override
    public void onPush() throws IOException {

        if (Main.SPACES.isEmpty()) {
            System.out.println(Config.NO_EXISTING_SPACES);
            Main.ADMIN.getToMenu();

        }
        else {
            Main.SPACE_MODIFIER.start();
            Main.ADMIN.getToMenu();
        }

    }

    @Override
    public void onPush(Customer customer) throws IOException {

    }

    @Override
    public void show() {
        Main.BUTTON_SHOWER.showButton(this, Main.ADMIN_MENU_BUTTONS);
    }

    @Override
    public String getText() {
        return buttonText;
    }
}
