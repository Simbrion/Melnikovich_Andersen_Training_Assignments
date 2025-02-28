import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation implements Describable {
    private int id;
    private Space space;
    private String customerName;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public Space getSpace() {
        return this.space;
    }

    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public String getCustomerName() {
        return this.customerName;
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
                                                this.customerName,
                                                this.getSpace().getName(),
                                                this.getDate(),
                                                this.getStartTime(),
                                                this.getEndTime()));
    }
}
