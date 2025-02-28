package CustomerMenu;

public class CustomerShowSpacesOption implements MenuOption {

    @Override
    public void show() {
        Main.spaceListViewer.printList();
        this.getToMenu();
        break;
    }
}
