import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import InputValidators.*;

public class Main implements Menu {

    //System & utility modules initialization
    public static final Main session = new Main();
    public static final Admin admin = new Admin();
    public static final CustomerLogIn login = new CustomerLogIn();

    public static final InputValidator inputValidator = new InputValidator();
    public static final CharsOrDigitsInputValidator charsOrDigitsInputValidator = new CharsOrDigitsInputValidator();
    public static final PositiveDigitValidator positiveDigitValidator = new PositiveDigitValidator();
    public static final TimeInputValidator timeInputValidator = new TimeInputValidator();
    public static final DateInputValidator dateInputValidator = new DateInputValidator();

    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //Memory storages initialization
    protected static final List<Customer> customersList = new ArrayList<>();
    protected static final List<Reservation> reservationsList = new ArrayList<>();
    protected static final List<Space> spacesList = new ArrayList<>();

    //Space operations modules initialization
    public static final SpaceModifier spaceModifier = new SpaceModifier();
    public static final SpaceDeleter spaceDeleter = new SpaceDeleter();
    public static final SpaceCreator spaceCreator = new SpaceCreator();
    public static final SpaceTypeModifier spaceTypeModifier = new SpaceTypeModifier();
    public static final SpaceNameModifier spaceNameModifier = new SpaceNameModifier();
    public static final SpacePriceModifier spacePriceModifier = new SpacePriceModifier();
    public static final SpacePriceSelector spacePriceSelector = new SpacePriceSelector();
    public static final SpaceTypeSelector spaceTypeSelector = new SpaceTypeSelector();

    //List viewers initialization
    public static final SpaceListViewer spaceListViewer = new SpaceListViewer();
    public static final ReservationsListViewer reservationListViewer = new ReservationsListViewer();
    public static final CustomerListViewer customerListViewer = new CustomerListViewer();

    //Reservation operations modules initialization
    public static final ReservationCreator reservationCreator = new ReservationCreator();
    public static final ReservationCanceller reservationCanceller = new ReservationCanceller();
    public static final ReservationDateSelector reservationDateSelector = new ReservationDateSelector();
    public static final ReservationStartTimeSelector reservationStartTimeSelector = new ReservationStartTimeSelector();
    public static final ReservationEndTimeSelector  reservationEndTimeSelector = new ReservationEndTimeSelector();
    public static final ReservationSpaceSelector reservationSpaceSelector = new ReservationSpaceSelector();
    public static final TimeOverlapChecker timeOverlapChecker = new TimeOverlapChecker();


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
