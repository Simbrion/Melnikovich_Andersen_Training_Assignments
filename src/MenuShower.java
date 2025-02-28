import java.util.HashSet;
import java.util.List;

public class MenuShower {

    public void showMenu(HashSet<Integer> buttonNumbersSet, List<MenuButton> buttonsList ) {

        if (buttonNumbersSet.isEmpty()) {
            for (MenuButton button : buttonsList) {
                buttonNumbersSet.add(buttonsList.indexOf(button));
            }
        }

        for (MenuButton button : buttonsList) {
            if (buttonsList.indexOf(button) != 0) button.show();
        }
        buttonsList.get(0).show();
    }


}
