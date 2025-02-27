import java.io.IOException;

public class SpaceCreator {

    public void start() throws IOException {
        boolean newSpaceNameIsOriginal = true;

        System.out.println("Please provide a name for the new space.");
        String newSpaceName = Main.reader.readLine();

        for (Space space : Main.spacesList) {
            if (newSpaceName.equalsIgnoreCase(space.getName())) {
                System.out.println(Config.RED_COLOUR + "Space with this name already exists. Please choose another name." + Config.RESET_COLOUR);
                newSpaceNameIsOriginal = false;
                this.start();
            }
        }

        if (newSpaceNameIsOriginal) {
            Space newSpace = new Space();
            newSpace.initialize(newSpaceName);
            Main.spacesList.add(newSpace);
            System.out.println(Config.GREEN_COLOUR + "A new space has been created!" + Config.RESET_COLOUR);
            newSpace.printDescription();
        }
    }

}
