import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import UserInputValidators.*;

public class Main implements Menu {

    //System & utility modules initialization
    public static final Main SESSION = new Main();
    public static final Admin ADMIN = new Admin();
    public static final CustomerLogIn LOGIN = new CustomerLogIn();
    public static final InputValidator INPUT_VALIDATOR = new InputValidator();
    public static final CharsOrDigitsInputValidator CHARS_OR_DIGITS_INPUT_VALIDATOR = new CharsOrDigitsInputValidator();
    public static final PositiveDigitValidator POSITIVE_DIGIT_VALIDATOR = new PositiveDigitValidator();
    public static final TimeInputValidator TIME_INPUT_VALIDATOR = new TimeInputValidator();
    public static final DateInputValidator DATE_INPUT_VALIDATOR = new DateInputValidator();
    public static final MenuInputValidator MENU_INPUT_VALIDATOR = new MenuInputValidator();
    public static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    public static final MenuButtonShower BUTTON_SHOWER = new MenuButtonShower();
    public static final MenuShower MENU_SHOWER = new MenuShower();
    public static final HashSet<Integer> MAIN_MENU_OPTION_NUMBERS = new HashSet<>();

    //Admin menu buttons initialization
    public static final AdminMenuBackToLoginButton ADM_BACK_TO_LOGIN_BUTTON = new AdminMenuBackToLoginButton();
    public static final AdminMenuExitButton ADM_EXIT_BUTTON = new AdminMenuExitButton();
    public static final AdminMenuCreateSpaceButton ADM_CREATE_SPACE_BUTTON = new AdminMenuCreateSpaceButton();
    public static final AdminMenuShowReservationsButton ADM_SHOW_RESERV_BUTTON = new AdminMenuShowReservationsButton();
    public static final AdminMenuUpdateSpaceButton ADM_UPDATE_SPACE_BUTTON = new AdminMenuUpdateSpaceButton();
    public static final AdminMenuShowCustomersButton ADM_SHOW_CUSTOMERS_BUTTON = new AdminMenuShowCustomersButton();
    public static final AdminMenuDeleteSpaceButton ADM_DELETE_SPACE_BUTTON = new AdminMenuDeleteSpaceButton();
    public static final AdminMenuShowSpacesButton ADM_SHOW_SPACES_BUTTON = new AdminMenuShowSpacesButton();
    public static final List<MenuButton> ADMIN_MENU_BUTTONS = new ArrayList<>();
    static {
        ADMIN_MENU_BUTTONS.add(ADM_EXIT_BUTTON);
        ADMIN_MENU_BUTTONS.add(ADM_CREATE_SPACE_BUTTON);
        ADMIN_MENU_BUTTONS.add(ADM_UPDATE_SPACE_BUTTON);
        ADMIN_MENU_BUTTONS.add(ADM_DELETE_SPACE_BUTTON);
        ADMIN_MENU_BUTTONS.add(ADM_SHOW_SPACES_BUTTON);
        ADMIN_MENU_BUTTONS.add(ADM_SHOW_CUSTOMERS_BUTTON);
        ADMIN_MENU_BUTTONS.add(ADM_SHOW_RESERV_BUTTON);
        ADMIN_MENU_BUTTONS.add(ADM_BACK_TO_LOGIN_BUTTON);
    }

    //Customer menu buttons initialisation
    public static final CustMenuShowSpacesButton CUST_SHOW_SPACES_BUTTON = new CustMenuShowSpacesButton();
    public static final CustMenuCreateReservButton CUST_CREATE_RESERV_BUTTON = new CustMenuCreateReservButton();
    public static final CustMenuShowReservButton CUST_SHOW_RESERV_BUTTON = new CustMenuShowReservButton();
    public static final CustMenuCancelReservButton CUST_CANCEL_RESERV_BUTTON = new CustMenuCancelReservButton();
    public static final CustMenuBackToLoginButton CUST_BACK_TO_LOGIN_BUTTON = new CustMenuBackToLoginButton();
    public static final CustMenuExitButton CUST_EXIT_BUTTON = new CustMenuExitButton();
    public static final List<MenuButton> CUST_MENU_BUTTONS = new ArrayList<>();
    static {
        CUST_MENU_BUTTONS.add(CUST_EXIT_BUTTON);
        CUST_MENU_BUTTONS.add(CUST_SHOW_SPACES_BUTTON);
        CUST_MENU_BUTTONS.add(CUST_CREATE_RESERV_BUTTON);
        CUST_MENU_BUTTONS.add(CUST_SHOW_RESERV_BUTTON);
        CUST_MENU_BUTTONS.add(CUST_CANCEL_RESERV_BUTTON);
        CUST_MENU_BUTTONS.add(CUST_BACK_TO_LOGIN_BUTTON);
    }

    //Main menu buttons initialization
    public static final MainMenuLoginCustButton MAIN_LOGIN_CUST_BUTTON = new MainMenuLoginCustButton();
    public static final MainMenuLoginAdminButton MAIN_LOGIN_ADMIN_BUTTON = new MainMenuLoginAdminButton();
    public static final MainMenuExitButton MAIN_EXIT_BUTTON = new MainMenuExitButton();
    public static final List<MenuButton> MAIN_MENU_BUTTONS = new ArrayList<>();
    static {
        MAIN_MENU_BUTTONS.add(MAIN_EXIT_BUTTON);
        MAIN_MENU_BUTTONS.add(MAIN_LOGIN_CUST_BUTTON);
        MAIN_MENU_BUTTONS.add(MAIN_LOGIN_ADMIN_BUTTON);
    }

    //Memory storages initialization
    public static final List<Customer> CUSTOMERS = new ArrayList<>();
    public static final List<Reservation> RESERVATIONS = new ArrayList<>();
    public static final List<Space> SPACES = new ArrayList<>();

    //List viewers initialization
    public static final SpaceListViewer SPACE_LIST_VIEWER = new SpaceListViewer();
    public static final ReservationsListViewer RESERV_LIST_VIEWER = new ReservationsListViewer();
    public static final CustomerListViewer CUSTOMER_LIST_VIEWER = new CustomerListViewer();

    //Space operations modules initialization
    public static final SpaceModifier SPACE_MODIFIER = new SpaceModifier();
    public static final SpaceDeleter SPACE_DELETER = new SpaceDeleter();
    public static final SpaceCreator SPACE_CREATOR = new SpaceCreator();
    public static final SpaceTypeModifier SPACE_TYPE_MODIFIER = new SpaceTypeModifier();
    public static final SpaceNameModifier SPACE_NAME_MODIFIER = new SpaceNameModifier();
    public static final SpacePriceModifier SPACE_PRICE_MODIFIER = new SpacePriceModifier();
    public static final SpacePriceSelector SPACE_PRICE_SELECTOR = new SpacePriceSelector();
    public static final SpaceTypeSelector SPACE_TYPE_SELECTOR = new SpaceTypeSelector();

    //Reservation operations modules initialization
    public static final ReservationCreator RESERV_CREATOR = new ReservationCreator();
    public static final ReservationCanceller RESERV_CANCELLER = new ReservationCanceller();
    public static final ReservationDateSelector RESERV_DATE_SELECTOR = new ReservationDateSelector();
    public static final ReservationStartTimeSelector RESERV_START_TIME_SELECTOR = new ReservationStartTimeSelector();
    public static final ReservationEndTimeSelector RESERV_END_TIME_SELECTOR = new ReservationEndTimeSelector();
    public static final ReservationSpaceSelector RESERV_SPACE_SELECTOR = new ReservationSpaceSelector();
    public static final TimeOverlapChecker TIME_OVERLAP_CHECKER = new TimeOverlapChecker();


    public static void main(String[] args) throws Exception {

        // UNCOMMENT TO PERFORM INITIALIZATION WITH SOME DATA PRELOADED (FOR TESTING)
        new TestData().load();

        SESSION.getToMenu();

    }

    @Override
    public void getToMenu() throws IOException {

        System.out.println(Config.GREEN_COLOUR + "Welcome to Coworking Space Reservation App by Artem Melnikovich!" + Config.RESET_COLOUR);
        showMenu();
        String userInput = Main.READER.readLine();
        MENU_INPUT_VALIDATOR.validate(this, userInput);
        Main.MAIN_MENU_BUTTONS.get(Integer.parseInt(userInput)).onPush();

    }

    @Override
    public void showMenu() {
        MENU_SHOWER.showMenu(MAIN_MENU_OPTION_NUMBERS, MAIN_MENU_BUTTONS);
    }

    @Override
    public HashSet<Integer> getMenuOptionNumbers() {
        return MAIN_MENU_OPTION_NUMBERS;
    }

}
