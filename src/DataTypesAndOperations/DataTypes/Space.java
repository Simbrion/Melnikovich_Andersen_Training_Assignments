package DataTypesAndOperations.DataTypes;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

import Main.*;

public class Space implements Describable, Serializable {

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
        Main.SPACE_TYPE_SELECTOR.selectType(this);
        Main.SPACE_PRICE_SELECTOR.start(this);
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
            case TypeOfSpace.CONFERENCE_ROOM : {
                return "conference room";
            }
            case TypeOfSpace.PRIVATE_ROOM: {
                return "private room";
            }
            case TypeOfSpace.OPEN_SPACE: {
                return "open space";
            }
        }
        return null;
    }

    public boolean equals(Object object) {

        if (this == object) return true;

        if (object == null || getClass() != object.getClass()) {
            return false;

        }
        Space other = (Space) object;
        return (this.name.equals(other.getName()));


    }

    public int hashCode () {

        return Objects.hash(name);

    }


}
