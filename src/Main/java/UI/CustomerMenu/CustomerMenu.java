package UI.CustomerMenu;

import DataTypesAndOperations.DataTypes.Customer;
import MainPackage.Main;
import UI.Menu;

import java.io.IOException;
import java.util.HashSet;

public class CustomerMenu implements Menu {

    private static final HashSet<Integer> CUST_MENU_OPTION_NUMBERS = new HashSet<>();


    public void getToMenu(Customer customer) throws IOException {
        System.out.println("What you would like me to do?");
        showMenu();
        String userInput = Main.READER.readLine();
        Main.MENU_INPUT_VALIDATOR.validate(this, userInput);
        Main.CUST_MENU_BUTTONS.get(Integer.parseInt(userInput)).onPush(customer);
    }

    @Override
    public void getToMenu() throws IOException {
    }

    @Override
    public void showMenu() {
        Main.MENU_SHOWER.showMenu(CUST_MENU_OPTION_NUMBERS, Main.CUST_MENU_BUTTONS);
    }

    @Override
    public HashSet<Integer> getMenuOptionNumbers() {
        return CUST_MENU_OPTION_NUMBERS;
    }
}
