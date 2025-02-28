import java.io.IOException;
import java.util.HashSet;

public class Admin implements Menu {
    private HashSet<Integer> adminMenuButNumbersSet = new HashSet<>();

    @Override
    public void getToMenu() throws IOException {

        showMenu();
        String userInput = Main.reader.readLine();
        Main.menuInputValidator.checkMenuInput(this, userInput);
        Main.adminMenuButtons.get(Integer.parseInt(userInput)).onPush();

    }

    @Override
    public void showMenu() {
        Main.menuShower.showMenu(adminMenuButNumbersSet, Main.adminMenuButtons);
    }

    @Override
    public HashSet<Integer> getNumbersOfOptions() {
        return adminMenuButNumbersSet;
    }
}


