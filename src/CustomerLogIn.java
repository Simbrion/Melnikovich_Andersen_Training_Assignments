import java.io.IOException;

public class CustomerLogIn {

    public void logIn() throws IOException {
        boolean customerAlreadyExists = false;

        System.out.println("Please provide your name:");
        String userInput = Main.READER.readLine();

        boolean inputIsValid = Main.INPUT_VALIDATOR.validate(Main.CHARS_OR_DIGITS_INPUT_VALIDATOR, userInput);
        if (!inputIsValid) {
            System.out.println(Config.EMPTY_INPUT);
            logIn();
        }

        //Existing customer login
        if (!Main.CUSTOMERS.isEmpty()) {
            for (Customer existingCustomer : Main.CUSTOMERS) {
                if (existingCustomer.getName().equalsIgnoreCase(userInput)) {
                    customerAlreadyExists = true;
                    System.out.println("Nice to see you again, " + existingCustomer.getName() + '!');
                    existingCustomer.getToMenu();
                }
            }
        }

        //New customer login
        if (!customerAlreadyExists && inputIsValid) {
            Customer newCustomer = new Customer();
            newCustomer.setName(userInput);
            Main.CUSTOMERS.add(newCustomer);
            System.out.println("Welcome, new customer " + newCustomer.getName() + '!');
            newCustomer.getToMenu();
        }
    }
}