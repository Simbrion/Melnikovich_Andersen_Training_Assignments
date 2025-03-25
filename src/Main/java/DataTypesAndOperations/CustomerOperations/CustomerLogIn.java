package DataTypesAndOperations.CustomerOperations;

import java.io.IOException;

import DataTypesAndOperations.DataTypes.Customer;
import MainPackage.*;


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
        if (!Main.CUSTOMERS_DATABASE.isEmpty()) {
            for (Customer existingCustomer : Main.CUSTOMERS_DATABASE.getData()) {
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
            Main.CUSTOMERS_DATABASE.addCustomer(newCustomer);
            System.out.println("Welcome, new customer " + newCustomer.getName() + '!');
            newCustomer.getToMenu();
        }
    }
}