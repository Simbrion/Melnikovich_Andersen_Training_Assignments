package UI;

import java.util.HashSet;
import java.util.List;

public class MenuShower {

    public void showMenu(HashSet<Integer> buttonNumbersSet, List<MenuButton> buttonsList ) {


        if (buttonNumbersSet.isEmpty()) {
            buttonsList.forEach(button -> buttonNumbersSet.add(buttonsList.indexOf(button)));
        }


        buttonsList.stream().filter(button -> buttonsList.indexOf(button) != 0).forEach(MenuButton::show);
        buttonsList.getFirst().show();
    }


}
