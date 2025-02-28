import java.time.LocalDate;
import java.time.LocalTime;

public class TestData {

    public void load() {

        Space tallin = new Space();
        tallin.setName("TheOffice");
        tallin.setPrice(200);
        tallin.setType(TypeOfSpace.CONFERENCE_ROOM);
        Main.SPACES.add(tallin);

        Space riga = new Space();
        riga.setName("Room1408");
        riga.setPrice(200);
        riga.setType(TypeOfSpace.PRIVATE_ROOM);
        Main.SPACES.add(riga);

        Customer Beavis = new Customer();
        Beavis.setName("Beavis");
        Main.CUSTOMERS.add(Beavis);

        Customer Butthead = new Customer();
        Butthead.setName("Butthead");
        Main.CUSTOMERS.add(Butthead);

        Reservation reservation1 = new Reservation();
        reservation1.setCustomer(Beavis);
        reservation1.setSpace(tallin);
        reservation1.setDate(LocalDate.of(2022, 10, 15));
        reservation1.setStartTime(LocalTime.of(22, 00));
        reservation1.setEndTime(LocalTime.of(23, 00));
        reservation1.setId(101);
        Main.RESERVATIONS.add(reservation1);
        Beavis.addReservation(reservation1);

        Reservation reservation2 = new Reservation();
        reservation2.setCustomer(Butthead);
        reservation2.setSpace(tallin);
        reservation2.setDate(LocalDate.of(2023, 10, 15));
        reservation2.setStartTime(LocalTime.of(22, 00));
        reservation2.setEndTime(LocalTime.of(23, 00));
        reservation2.setId(102);
        Main.RESERVATIONS.add(reservation2);
        Butthead.addReservation(reservation2);



        Reservation reservation3 = new Reservation();
        reservation3.setCustomer(Beavis);
        reservation3.setSpace(riga);
        reservation3.setDate(LocalDate.of(2022, 10, 15));
        reservation3.setStartTime(LocalTime.of(22, 00));
        reservation3.setEndTime(LocalTime.of(23, 00));
        reservation3.setId(103);
        Main.RESERVATIONS.add(reservation3);
        Beavis.addReservation(reservation3);



        Reservation reservation4 = new Reservation();
        reservation4.setCustomer(Butthead);
        reservation4.setSpace(riga);
        reservation4.setDate(LocalDate.of(2023, 10, 15));
        reservation4.setStartTime(LocalTime.of(22, 00));
        reservation4.setEndTime(LocalTime.of(23, 00));
        reservation4.setId(104);
        Main.RESERVATIONS.add(reservation4);
        Butthead.addReservation(reservation4);


    }

}
