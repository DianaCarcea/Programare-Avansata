import java.util.Objects;

/**
 * The GasStation class that inherits the Location class
 */
public class GasStation extends Location {
    private String name;
    private String type="GasStation";
    private double coordinate_x,coordinate_y;
    private double price;

    /**
     * The GasStation class constructor
     * @param name
     * @param type
     * @param coordinate_x
     * @param coordinate_y
     * @param price
     */
    public GasStation(String name, String type, double coordinate_x, double coordinate_y, double price) {
        this.name = name;
        this.type = type;
        this.coordinate_x = coordinate_x;
        this.coordinate_y = coordinate_y;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCoordinate_x() {
        return coordinate_x;
    }

    public void setCoordinate_x(double coordinate_x) {
        this.coordinate_x = coordinate_x;
    }

    public double getCoordinate_y() {
        return coordinate_y;
    }

    public void setCoordinate_y(double coordinate_y) {
        this.coordinate_y = coordinate_y;
    }

    /**
     * @return the price of a GasStation
     */
    public double getPrice() {
        return coordinate_y;
    }

    /**
     * The price of the GasStation is set
     * @param price
     */
    public void setPrice(double price) {
        this.price=price;
    }

    @Override
    public String toString() {
        return "GasStation{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", coordinate_x=" + coordinate_x +
                ", coordinate_y=" + coordinate_y +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GasStation gasStation = (GasStation) o;
        return Double.compare(gasStation.coordinate_x, coordinate_x) == 0 && Double.compare(gasStation.coordinate_y, coordinate_y) == 0 && Double.compare(gasStation.price, price) == 0 && Objects.equals(name, gasStation.name) && Objects.equals(type, gasStation.type);
    }

}