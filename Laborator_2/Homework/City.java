import java.util.Objects;

/**
 * The City class that inherits the Location class
 */
public class City extends Location {
    private String name;
    private String type="City";
    private double coordinate_x,coordinate_y;
    private double population;

    /**
     * The City class constructor
     * @param name
     * @param type
     * @param coordinate_x
     * @param coordinate_y
     * @param population
     */
    public City(String name, String type, double coordinate_x, double coordinate_y,double population) {
        this.name = name;
        this.type = type;
        this.coordinate_x = coordinate_x;
        this.coordinate_y = coordinate_y;
        this.population=population;
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
     * @return the population of a city
     */
    public double getPopulation() {
        return coordinate_y;
    }

    /**
     * The population of the city is set
     * @param population
     */
    public void setPopulation(double population) {
        this.population=population;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", coordinate_x=" + coordinate_x +
                ", coordinate_y=" + coordinate_y +
                ", population=" + population +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Double.compare(city.coordinate_x, coordinate_x) == 0 && Double.compare(city.coordinate_y, coordinate_y) == 0 && Double.compare(city.population, population) == 0 && Objects.equals(name, city.name) && Objects.equals(type, city.type);
    }

}
