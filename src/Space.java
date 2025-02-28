import java.io.IOException;

public class Space implements Describable {

    private TypeOfSpace typeOfSpace;
    private String name;
    private int price;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(TypeOfSpace type) {
        this.typeOfSpace = type;
    }

    public void initialize(String nameOfNewSpace) throws IOException {
        this.setName(nameOfNewSpace);
        Main.spaceTypeSelector.selectType(this);
        Main.spacePriceSelector.selectPrice(this);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void printDescription() {
        System.out.println(Config.YELLOW_COLOUR + String.format(" - Space named %s, space type: %s, price per hour: USD %d.",
                this.name,
                this.getTypeAsString(),
                this.price) + Config.RESET_COLOUR);
    }

    public String getTypeAsString() {
        switch (this.typeOfSpace) {
            case CONFERENCE_ROOM : {
                return "conference room";
            }
            case PRIVATE_ROOM: {
                return "private room";
            }
            case OPEN_SPACE: {
                return "open space";
            }
        }
        return null;
    }
}
