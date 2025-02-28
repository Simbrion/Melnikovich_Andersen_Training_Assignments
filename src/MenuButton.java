import java.io.IOException;

public interface MenuButton {

    void onPush() throws IOException;

    void onPush(Customer customer) throws IOException;

    void show();

    String getText();

}
