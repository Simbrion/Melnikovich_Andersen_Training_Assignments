package DataTypesAndOperations.DataTypes;

import MainPackage.*;
import UI.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;


public class Customer implements Menu, Serializable {

    private String name;
    private static final HashSet<Integer> CUST_MENU_OPTION_NUMBERS = new HashSet<>();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
       return Optional.ofNullable(this.name).orElse("Unnamed_User");
    }

    public List<Reservation> getReservations() {
        List<Reservation> result = new ArrayList<>();
        for (Reservation reservation : Main.RESERVATIONS_DATABASE.getData()) {
            if (reservation.getCustomerName().equals(this.name)) result.add(reservation);
        }
        return result;
    }

    public void getToMenu() throws IOException {
        System.out.println("What you would like me to do?");
        showMenu();
        String userInput = Main.READER.readLine();
        Main.MENU_INPUT_VALIDATOR.validate(this, userInput);
        Main.CUST_MENU_BUTTONS.get(Integer.parseInt(userInput)).onPush(this);

    }

    @Override
    public void showMenu() {
        Main.MENU_SHOWER.showMenu(CUST_MENU_OPTION_NUMBERS, Main.CUST_MENU_BUTTONS);
    }

    @Override
    public HashSet<Integer> getMenuOptionNumbers() {
        return CUST_MENU_OPTION_NUMBERS;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Customer other = (Customer) object;
        return (this.name.equals(other.getName()));
    }

    public int hashCode () {
        return Objects.hash(name);

    }

}
