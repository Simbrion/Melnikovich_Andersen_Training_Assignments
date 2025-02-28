import java.io.IOException;

public class CustomerLogIn {

    public void logIn() throws IOException {
        boolean customerAlreadyExists = false;

        System.out.println("Please provide your name:");
        String userInput = Main.reader.readLine();

        //Existing customer login
        if (!Main.customersList.isEmpty()) {
            for (Customer existingCustomer : Main.customersList) {
                if (existingCustomer.getName().equalsIgnoreCase(userInput)) {
                    customerAlreadyExists = true;
                    System.out.println("Nice to see you again, " + existingCustomer.getName() + '!');
                    existingCustomer.getToMenu();
                }
            }
        }

        boolean inputIsValid = Main.inputValidator.validate(Main.charsOrDigitsInputValidator, userInput);
        if (!inputIsValid) {
            System.out.println(Config.EMPTY_INPUT);
            logIn();
        }

        //New customer login
        if (!customerAlreadyExists && inputIsValid) {
            Customer newCustomer = new Customer();
            newCustomer.setName(userInput);
            Main.customersList.add(newCustomer);
            System.out.println("Welcome, new customer " + newCustomer.getName() + '!');
            newCustomer.getToMenu();
        }
    }
}