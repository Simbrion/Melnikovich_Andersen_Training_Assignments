import java.io.IOException;
import java.util.HashSet;

public class Customer implements Menu {

    private String name;
    private HashSet<Integer> custMenuButNumbersSet = new HashSet<>();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    public void getToMenu() throws IOException {

        showMenu();
        String userInput = Main.reader.readLine();
        Main.menuInputValidator.checkMenuInput(this, userInput);
        Main.custMenuButtons.get(Integer.parseInt(userInput)).onPush(this);

    }

    @Override
    public void showMenu() {
        Main.menuShower.showMenu(custMenuButNumbersSet, Main.custMenuButtons);
    }

    @Override
    public HashSet<Integer> getNumbersOfOptions() {
        return custMenuButNumbersSet;
    }
}
