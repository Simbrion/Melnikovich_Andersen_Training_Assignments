import java.io.IOException;

public class SpaceModifier {

    public void start() throws IOException {

            System.out.println("What is the name of the space you want to modify?");
            Main.spaceListViewer.printList();
            String userInput = Main.reader.readLine();
            boolean spaceIsOnTheList = false;

            for (Space space : Main.spacesList) {
                if (userInput.equalsIgnoreCase(space.getName())) {
                    spaceIsOnTheList = true;
                    Main.spaceNameModifier.modifySpaceName(space);
                    Main.spaceTypeModifier.modifyType(space);
                    Main.spacePriceModifier.modifyPrice(space);
                    System.out.println(Config.GREEN_COLOUR + "Changes to the space have been saved!" + Config.RESET_COLOUR);
                    space.printDescription();
                    break;
                }
            }
            if (!spaceIsOnTheList) System.out.println(Config.NO_SPACE_WITH_NAME);

    }
}
