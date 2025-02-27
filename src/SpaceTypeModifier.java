import java.io.IOException;

public class SpaceTypeModifier {

    public void modifyType(Space space) throws IOException {

        while (true) {
            System.out.println("""
                               Do you want to change the type of the selected space?
                                 1. Yes
                                 2. No
                               """);
            String userInput = Main.reader.readLine();
            if (userInput.equals("1")) {
                new SpaceTypeSelector().selectType(space);
                break;
            }
            else if (userInput.equals("2")) {
                break;
            }
            else {
                System.out.println(Config.WRONG_INPUT_MESSAGE);
            }
        }
    }

}
