import java.io.IOException;

public class Customer implements Menu {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void getToMenu() throws IOException {

        System.out.println(this.name + ", what would you like me to do? " +
                "\n 1. Browse available spaces" +
                "\n 2. Make a reservation" +
                "\n 3. Show my reservations" +
                "\n 4. Cancel my reservation" +
                "\n 5. Back to login menu" +
                "\n\n 0. Exit");

        String userInput = Main.reader.readLine();
        switch (userInput) {
            case "1" :{
                new SpaceListViewer().printList();
                this.getToMenu();
                break;
            }
            case "2" : {
                if (Main.spacesList.isEmpty()) {
                    System.out.println(Config.NO_EXISTING_SPACES);
                    this.getToMenu();
                    break;
                }
                else {
                    new ReservationCreator().createReservation(this.getName());
                    this.getToMenu();
                    break;
                }
            }
            case "3" : {
                new ReservationsListViewer().printCustomerReservationsList(this.getName());
                this.getToMenu();
                break;
            }
            case "4" : {
                new ReservationCanceller().cancelReservation(this);
                this.getToMenu();
                break;
            }
            case "5" : {
                Main.session.getToMenu();
                break;
            }
            case "0" : {
                System.out.println(Config.EXIT_MESSAGE);
                System.exit(0);
                break;
                }
            default: {
                System.out.println(Config.WRONG_INPUT_MESSAGE);
                this.getToMenu();
            }
        }
    }
}
