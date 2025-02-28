public class Config {

    private Config(){}

    public static final String YELLOW_COLOUR ="\u001B[33m";
    public static final String GREEN_COLOUR ="\u001B[32m";
    public static final String RESET_COLOUR = "\u001B[0m";
    public static final String RED_COLOUR = "\u001B[31m";


    public static final String WRONG_INPUT_MESSAGE = (RED_COLOUR + "Unacceptable input! Please try again." + RESET_COLOUR);
    public static final String NO_SPACE_WITH_NAME = (RED_COLOUR + "There is no space with such name." + RESET_COLOUR);
    public static final String EXIT_MESSAGE = (GREEN_COLOUR + "You have exited the application. See you next time!" + RESET_COLOUR);
    public static final String NO_EXISTING_SPACES = (YELLOW_COLOUR + "There are no existing spaces." + RESET_COLOUR);
    public static final String NO_EXISTING_RESERVATIONS = (YELLOW_COLOUR + "There are no existing reservations." + RESET_COLOUR);
    public static final String NO_EXISTING_CUSTOMERS = (YELLOW_COLOUR + "There are no existing customers." + RESET_COLOUR);
    public static final String WRONG_INPUT_EXCEPTION = (RED_COLOUR + "!!! Input Exception caught !!!" + RESET_COLOUR);
    public static final String EMPTY_INPUT = (RED_COLOUR + "Empty input not allowed. Please use letters and/or digits." + RESET_COLOUR);
}
