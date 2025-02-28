import java.io.IOException;

public class SpaceTypeSelector {

    public void selectType(Space space) throws IOException {
        System.out.println("Please indicate the type of the space " + space.getName() +
                "\n 1. Open space" +
                "\n 2. Private room" +
                "\n 3. Conference room");
        String userInput = Main.reader.readLine();
        switch (userInput) {
            case "1": {
                space.setType(TypeOfSpace.OPEN_SPACE);
                break;
            }
            case "2": {
                space.setType(TypeOfSpace.PRIVATE_ROOM);
                break;
            }
            case "3": {
                space.setType(TypeOfSpace.CONFERENCE_ROOM);
                break;
            }
            default: {
                System.out.println(Config.WRONG_INPUT_MESSAGE);
                this.selectType(space);
            }
        }
    }

}
