import java.time.LocalDate;
import java.time.LocalTime;

public class TestData {

    public void load() {

        Space tallin = new Space();
        tallin.setName("TheOffice");
        tallin.setPrice(200);
        tallin.setType(TypeOfSpace.CONFERENCE_ROOM);
        Main.spacesList.add(tallin);

        Space riga = new Space();
        riga.setName("Room1408");
        riga.setPrice(200);
        riga.setType(TypeOfSpace.PRIVATE_ROOM);
        Main.spacesList.add(riga);

        Customer customer1 = new Customer();
        customer1.setName("Beavis");
        Main.customersList.add(customer1);

        Customer customer2 = new Customer();
        customer2.setName("Butthead");
        Main.customersList.add(customer2);

        Reservation reservation1 = new Reservation();
        reservation1.setCustomerName("Beavis");
        reservation1.setSpace(tallin);
        reservation1.setDate(LocalDate.of(2022, 10, 15));
        reservation1.setStartTime(LocalTime.of(22, 00));
        reservation1.setEndTime(LocalTime.of(23, 00));
        reservation1.setId(101);
        Main.reservationsList.add(reservation1);

        Reservation reservation2 = new Reservation();
        reservation2.setCustomerName("Butthead");
        reservation2.setSpace(tallin);
        reservation2.setDate(LocalDate.of(2023, 10, 15));
        reservation2.setStartTime(LocalTime.of(22, 00));
        reservation2.setEndTime(LocalTime.of(23, 00));
        reservation2.setId(102);
        Main.reservationsList.add(reservation2);


        Reservation reservation3 = new Reservation();
        reservation3.setCustomerName("Beavis");
        reservation3.setSpace(riga);
        reservation3.setDate(LocalDate.of(2022, 10, 15));
        reservation3.setStartTime(LocalTime.of(22, 00));
        reservation3.setEndTime(LocalTime.of(23, 00));
        reservation3.setId(103);
        Main.reservationsList.add(reservation3);


        Reservation reservation4 = new Reservation();
        reservation4.setCustomerName("Butthead");
        reservation4.setSpace(riga);
        reservation4.setDate(LocalDate.of(2023, 10, 15));
        reservation4.setStartTime(LocalTime.of(22, 00));
        reservation4.setEndTime(LocalTime.of(23, 00));
        reservation4.setId(104);
        Main.reservationsList.add(reservation4);

    }

}
