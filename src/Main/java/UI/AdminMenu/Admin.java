package UI.AdminMenu;

import MainPackage.*;
import UI.*;

import java.io.IOException;
import java.util.HashSet;

public class Admin implements Menu {
    private HashSet<Integer> adminMenuButNumbersSet = new HashSet<>();

    @Override
    public void getToMenu() throws IOException {

        System.out.println("Administrator, what you would like me to do?");
        showMenu();
        String userInput = Main.READER.readLine();
        Main.MENU_INPUT_VALIDATOR.validate(this, userInput);
        Main.ADMIN_MENU_BUTTONS.get(Integer.parseInt(userInput)).onPush();

    }

    @Override
    public void showMenu() {
        Main.MENU_SHOWER.showMenu(adminMenuButNumbersSet, Main.ADMIN_MENU_BUTTONS);
    }

    @Override
    public HashSet<Integer> getMenuOptionNumbers() {
        return adminMenuButNumbersSet;
    }
}


