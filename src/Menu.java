import java.io.IOException;
import java.util.HashSet;

public interface Menu {

    void getToMenu() throws IOException;

    void showMenu();

    HashSet<Integer> getNumbersOfOptions();

}
