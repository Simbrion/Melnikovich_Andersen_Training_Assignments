import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
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
    public static final MenuInputValidator menuInputValidator = new MenuInputValidator();
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final MenuButtonShower buttonShower = new MenuButtonShower();
    public static final MenuShower menuShower = new MenuShower();
    private HashSet<Integer> mainMenuButNumbersSet = new HashSet<>();

    //Admin menu buttons initialization
    public static final List<MenuButton> adminMenuButtons = new ArrayList<>();
    public static final AdminMenuBackToLoginButton adminMenuBackToLoginButton = new AdminMenuBackToLoginButton();
    public static final AdminMenuExitButton adminMenuExitButton = new AdminMenuExitButton();
    public static final AdminMenuCreateSpaceButton adminMenuCreateSpaceButton = new AdminMenuCreateSpaceButton();
    public static final AdminMenuShowReservationsButton adminMenuShowReservationsButton = new AdminMenuShowReservationsButton();
    public static final AdminMenuUpdateSpaceButton adminMenuUpdateSpaceButton = new AdminMenuUpdateSpaceButton();
    public static final AdminMenuShowCustomersButton adminMenuShowCustomersButton = new AdminMenuShowCustomersButton();
    public static final AdminMenuDeleteSpaceButton adminMenuDeleteSpaceButton = new AdminMenuDeleteSpaceButton();
    public static final AdminMenuShowSpacesButton adminMenuShowSpacesButton = new AdminMenuShowSpacesButton();

    //Customer menu buttons initialisation
    public static final List<MenuButton> custMenuButtons = new ArrayList<>();
    public static final CustMenuButtonShowSpaces custMenuButtonShowSpaces = new CustMenuButtonShowSpaces();
    public static final CustMenuButtonCreateReserv custMenuButtonCreateReserv  = new CustMenuButtonCreateReserv();
    public static final CustMenuButtonShowReserv custMenuButtonShowReserv = new CustMenuButtonShowReserv();
    public static final CustMenuButtonCancelReserv custMenuButtonCancelReserv = new CustMenuButtonCancelReserv();
    public static final CustMenuButtonBackToLogin custMenuButtonBackToLogin = new CustMenuButtonBackToLogin();
    public static final CustMenuButtonExit custMenuButtonExit = new CustMenuButtonExit();

    //Main menu buttons initialization
    public static final List<MenuButton> mainMenuButtons = new ArrayList<>();
    public static final MainMenuLoginCustButton mainMenuLoginCustButton = new MainMenuLoginCustButton();
    public static final MainMenuLoginAdminButton mainMenuLoginAdminButton = new MainMenuLoginAdminButton();
    public static final MainMenuExitButton mainMenuExitButton = new MainMenuExitButton();

    //Memory storages initialization
    public static final List<Customer> customersList = new ArrayList<>();
    public static final List<Reservation> reservationsList = new ArrayList<>();
    public static final List<Space> spacesList = new ArrayList<>();

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

        session.initializeMenuButtons();
        session.getToMenu();

    }

    @Override
    public void getToMenu() throws IOException {

        System.out.println(Config.GREEN_COLOUR + "Welcome to Coworking Space Reservation App by Artem Melnikovich!" + Config.RESET_COLOUR);
        System.out.println("Please log in as:");
        showMenu();

        String userInput = Main.reader.readLine();
        menuInputValidator.checkMenuInput(this, userInput);
        Main.mainMenuButtons.get(Integer.parseInt(userInput)).onPush();

    }

    @Override
    public void showMenu() {
        menuShower.showMenu(mainMenuButNumbersSet, mainMenuButtons);
    }

    @Override
    public HashSet<Integer> getNumbersOfOptions() {
        return mainMenuButNumbersSet;
    }

    private void initializeMenuButtons() {

        //Main menu
        mainMenuButtons.add(mainMenuExitButton);
        mainMenuButtons.add(mainMenuLoginCustButton);
        mainMenuButtons.add(mainMenuLoginAdminButton);

        //Customer menu
        custMenuButtons.add(custMenuButtonExit);
        custMenuButtons.add(custMenuButtonShowSpaces);
        custMenuButtons.add(custMenuButtonCreateReserv);
        custMenuButtons.add(custMenuButtonShowReserv);
        custMenuButtons.add(custMenuButtonCancelReserv);
        custMenuButtons.add(custMenuButtonBackToLogin);

        //Admin menu
        adminMenuButtons.add(adminMenuExitButton);
        adminMenuButtons.add(adminMenuCreateSpaceButton);
        adminMenuButtons.add(adminMenuUpdateSpaceButton);
        adminMenuButtons.add(adminMenuDeleteSpaceButton);
        adminMenuButtons.add(adminMenuShowSpacesButton);
        adminMenuButtons.add(adminMenuShowCustomersButton);
        adminMenuButtons.add(adminMenuShowReservationsButton);
        adminMenuButtons.add(adminMenuBackToLoginButton);
    }

}
