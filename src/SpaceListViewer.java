public class SpaceListViewer implements ListViewer {

    public void printList () {
        if (Main.spacesList.isEmpty()) System.out.println(Config.NO_EXISTING_SPACES);
        else {
            System.out.println(Config.YELLOW_COLOUR + "There are the following spaces registered in the system:" + Config.RESET_COLOUR);
            for (Space space : Main.spacesList) space.printDescription();
        }
    }
}
