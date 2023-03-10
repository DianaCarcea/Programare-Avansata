import java.util.Objects;

/**
 * The Airport class that inherits the Location class
 */
public class Airport extends Location {
    private String name;
    private String type="Airport";
    private double coordinate_x,coordinate_y;
    private double terminals;

    /**
     * The Airport class constructor
     * @param name
     * @param type
     * @param coordinate_x
     * @param coordinate_y
     * @param terminals
     */
    public Airport(String name, String type, double coordinate_x, double coordinate_y, double terminals) {
        this.name = name;
        this.type = type;
        this.coordinate_x = coordinate_x;
        this.coordinate_y = coordinate_y;
        this.terminals=terminals;
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
     * @return the terminals of a airport
     */
    public double getTerminals() {
        return coordinate_y;
    }

    /**
     * The terminals of the airport is set
     * @param terminals
     */
    public void setTerminalserminals(double terminals) {
        this.terminals=terminals;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", coordinate_x=" + coordinate_x +
                ", coordinate_y=" + coordinate_y +
                ", terminals=" + terminals +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Double.compare(airport.coordinate_x, coordinate_x) == 0 && Double.compare(airport.coordinate_y, coordinate_y) == 0 && Double.compare(airport.terminals, terminals) == 0 && Objects.equals(name, airport.name) && Objects.equals(type, airport.type);
    }

}