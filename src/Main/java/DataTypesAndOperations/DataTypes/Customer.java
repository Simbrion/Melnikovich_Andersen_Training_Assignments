package DataTypesAndOperations.DataTypes;

import MainPackage.*;
import UI.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;


public class Customer implements Menu, Serializable {

    private String name;
    private List<Reservation> customerReservations = new ArrayList<>();
    private HashSet<Integer> custMenuOptionNumbers = new HashSet<>();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
       return Optional.ofNullable(this.name).orElse("Unnamed_User");
    }

    public void addReservation(Reservation reservation) {
        customerReservations.add(reservation);
    }

    public List<Reservation> getReservations() {
        return customerReservations;
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
        Main.MENU_SHOWER.showMenu(custMenuOptionNumbers, Main.CUST_MENU_BUTTONS);
    }

    @Override
    public HashSet<Integer> getMenuOptionNumbers() {
        return custMenuOptionNumbers;
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
