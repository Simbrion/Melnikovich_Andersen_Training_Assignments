import java.util.List;

public class MenuButtonShower {

    public void showButton(MenuButton button, List<MenuButton> menuButtonList) {
        System.out.println(menuButtonList.indexOf(button) + ". " + button.getText());
    }

}
