package DataTypesAndOperations.DataTypes;

import MainPackage.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


@Entity
@Table(name = "reservation")
public class Reservation implements Describable, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "space_name", nullable = false)
    private Space space;

    @ManyToOne
    @JoinColumn(name = "customer_name", nullable = false)
    private Customer customer;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;


    public int getId() {
        return this.id;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public void setSpace(String spaceName) {
        for (Space iteratedSpace : Main.SPACES_DATABASE.getData()){
            if (iteratedSpace.getName().equals(spaceName)) this.setSpace(iteratedSpace);
        }
    }

    public Space getSpace() {
        return this.space;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCustomer(String customerName) {
        for (Customer iteratedCustomer : Main.CUSTOMERS_DATABASE.getData())
            if (iteratedCustomer.getName().equals(customerName)) {
                this.customer = iteratedCustomer;
            }
    }


    public String getCustomerName() {
        return this.customer.getName();
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setStartTime(LocalTime time) {
        this.startTime = time;
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public void setEndTime(LocalTime time) {
        this.endTime = time;
    }

    public LocalTime getEndTime() {
        return this.endTime;
    }

    public void printDescription() {
        System.out.println(String.format(Config.YELLOW_COLOUR + " -Reservation id: %d, reserved by %s, reserved space: %s, reserved slot: %tF, %tR-%tR." + Config.RESET_COLOUR,
                                                this.getId(),
                                                this.customer.getName(),
                                                this.getSpace().getName(),
                                                this.getDate(),
                                                this.getStartTime(),
                                                this.getEndTime()));
    }


    public boolean equals(Object object) {

        if (this == object) return true;

        if (object == null || getClass() != object.getClass()) {
            return false;

        }

        Reservation other = (Reservation) object;
        return (this.id == other.id);

    }

    public int hashCode () {

        return Objects.hash(id);

    }


}
