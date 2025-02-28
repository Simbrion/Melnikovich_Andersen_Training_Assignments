import java.io.IOException;

public class AdminMenuUpdateSpaceButton implements MenuButton {
    private String buttonText = "Update an existing new space";

    @Override
    public void onPush() throws IOException {

        if (Main.spacesList.isEmpty()) {
            System.out.println(Config.NO_EXISTING_SPACES);
            Main.admin.getToMenu();

        }
        else {
            Main.spaceModifier.start();
            Main.admin.getToMenu();
        }

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
