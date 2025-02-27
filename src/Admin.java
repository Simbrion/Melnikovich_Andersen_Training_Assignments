import java.io.IOException;

public class Admin implements Menu {

    public void getToMenu() throws IOException {

        System.out.println("""
                            Administrator, what would you like me to do?
                               1. Create a new space
                               2. Delete an existing space
                               3. Update an existing space
                               4. Show all existing spaces
                               5. Show all reservations
                               6. Show all customers
                               7. Back to the login menu
                                               
                               0. Exit
                            """);

        String userInput = Main.reader.readLine();
        switch (userInput) {
            case "1":
                new SpaceCreator().start();
                this.getToMenu();
                break;
            case "2":
                new SpaceDeleter().start();
                this.getToMenu();
                break;
            case "3":
                if (Main.spacesList.isEmpty()) {
                    System.out.println(Config.NO_EXISTING_SPACES);
                    this.getToMenu();
                    break;
                }
                else {
                    SpaceModifier spaceModifier = new SpaceModifier();
                    spaceModifier.start();
                    this.getToMenu();
                    break;
                }
            case "4":
                SpaceListViewer spaceViewer = new SpaceListViewer();
                spaceViewer.printList();
                this.getToMenu();
                break;
            case "5":
                new ReservationsListViewer().printList();
                this.getToMenu();
                break;
            case "6":
                new CustomerListViewer().printList();
                this.getToMenu();
                break;
            case "7":
                Main.session.getToMenu();
                break;
            case "0":
                System.out.println(Config.EXIT_MESSAGE);
                System.exit(0);
                break;
            default:
                System.out.println(Config.WRONG_INPUT_MESSAGE);
                this.getToMenu();
                break;
        }
    }
}

