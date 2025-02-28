import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main implements Menu {

    protected static final List<Customer> customersList = new ArrayList<>();
    protected static final List<Reservation> reservationsList = new ArrayList<>();
    protected static final List<Space> spacesList = new ArrayList<>();
    public static final InputValidator inputValidator = new InputValidator();
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final Admin admin = new Admin();
    public static final CustomerLogIn login = new CustomerLogIn();
    public static final Main session = new Main();


    public static void main(String[] args) throws Exception {

        // UNCOMMENT TO PERFORM INITIALIZATION WITH SOME DATA PRELOADED (FOR TESTING)
        //new TestData().load();

        session.getToMenu();

    }

    public void getToMenu() throws IOException {

         System.out.println(Config.GREEN_COLOUR + "Welcome to Coworking Space Reservation App by Artem Melnikovich!" + Config.RESET_COLOUR);
        System.out.println("""
                            Please log in as:
                                1. Customer
                                2. Administrator 
                                0. Exit
                           """);
        String userInput = reader.readLine();
        switch (userInput) {
            case ("1"):
                login.logIn();
                break;
            case ("2"):
                admin.getToMenu();
                break;
            case ("0"): {
                System.out.println(Config.EXIT_MESSAGE);
                System.exit(0);
                break;
            }
            default:
                System.out.println(Config.WRONG_INPUT_MESSAGE);
                this.getToMenu();
        }
    }

}
