import java.io.IOException;

public class SpaceNameModifier {

    public void modifySpaceName(Space space) throws IOException {
        System.out.println("Please provide a new name for the space " + space.getName() + ". Insert \"N\" if you do not want to change the name.");
        String userInput = Main.reader.readLine();
        if (!(userInput.equalsIgnoreCase("n"))) space.setName(userInput);
    }

}
