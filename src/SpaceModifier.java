import java.io.IOException;

public class SpaceModifier {

    public void start() throws IOException {

            System.out.println(Config.YELLOW_COLOUR + "What is the name of the space you want to modify?" + Config.RESET_COLOUR);
            Main.SPACE_LIST_VIEWER.printList();
            String userInput = Main.READER.readLine();
            boolean spaceIsOnTheList = false;

            for (Space space : Main.SPACES) {
                if (userInput.equalsIgnoreCase(space.getName())) {
                    spaceIsOnTheList = true;
                    Main.SPACE_NAME_MODIFIER.modifySpaceName(space);
                    Main.SPACE_TYPE_MODIFIER.modifyType(space);
                    Main.SPACE_PRICE_MODIFIER.modifyPrice(space);
                    System.out.println(Config.GREEN_COLOUR + "Changes to the space have been saved!" + Config.RESET_COLOUR);
                    space.printDescription();
                    break;
                }
            }
            if (!spaceIsOnTheList) System.out.println(Config.NO_SPACE_WITH_NAME);

    }
}
