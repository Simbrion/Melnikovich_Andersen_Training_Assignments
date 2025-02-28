import java.io.IOException;

public class AdminMenuShowSpacesButton implements MenuButton {
    private String buttonText = "Show all available spaces";

    @Override
    public void onPush() throws IOException {
        Main.spaceListViewer.printList();
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
