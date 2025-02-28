import java.io.IOException;

public class SpaceCreator {

    public void start() throws IOException {
        boolean newSpaceNameIsOriginal = true;

        System.out.println("Please provide a name for the new space.");
        String userInput = Main.reader.readLine();

        boolean inputIsValid = Main.inputValidator.isCharsOrDigits(userInput);

        if (inputIsValid) {
            System.out.println(Config.EMPTY_INPUT);
            start();
        }

        for (Space space : Main.spacesList) {
            if (userInput.equalsIgnoreCase(space.getName())) {
                System.out.println(Config.RED_COLOUR + "Space with this name already exists. Please choose another name." + Config.RESET_COLOUR);
                newSpaceNameIsOriginal = false;
                Main.admin.getToMenu();
            }
        }

        if (newSpaceNameIsOriginal && inputIsValid) {
            Space newSpace = new Space();
            newSpace.initialize(userInput);
            Main.spacesList.add(newSpace);
            System.out.println(Config.GREEN_COLOUR + "A new space has been created!" + Config.RESET_COLOUR);
            newSpace.printDescription();
        }
    }

}
