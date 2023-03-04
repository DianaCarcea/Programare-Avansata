public class Location {
    public enum Locations{
        city, airport, gas_stations,park,hospital,police,school,church, monastery,restaurant
    }
    private String name;
    private Locations type;
    private double coordinate_x,coordinate_y;

    public Location(String name, Locations type, double coordinate_x, double coordinate_y) {
        this.name = name;
        this.type = type;
        this.coordinate_x = coordinate_x;
        this.coordinate_y = coordinate_y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Locations getType() {
        return type;
    }

    public void setType(Locations type) {
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

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", coordinate_x=" + coordinate_x +
                ", coordinate_y=" + coordinate_y +
                '}';
    }
}
