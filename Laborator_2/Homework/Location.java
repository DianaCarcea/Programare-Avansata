/**
 * Abstract class Location
 */
public abstract class Location {
    /**
     * @return the name of location
     */
    public abstract String getName();

    /**
     * The name of the location is set
     * @param name
     */
    public abstract void setName(String name);

    /**
     * @return the type of location
     */
    public abstract String getType();

    /**
     * The type of the location is set
     * @param type
     */
    public abstract void setType(String type);

    /**
     * @return the x coordinate of the location is obtained
     */
    public abstract double getCoordinate_x();

    /**
     * The x coordinate of the location is set
     * @param coordinate_x
     */
    public abstract void setCoordinate_x(double coordinate_x) ;

    /**
     * @return the y coordinate of the location is obtained
     */
    public abstract double getCoordinate_y();

    /**
     * The y coordinate of the location is set
     * @param coordinate_y
     */
    public abstract void setCoordinate_y(double coordinate_y);

    /**
     * @return a representation of the Location object information
     */
    @Override
    public abstract String toString();

    /**
     * @param obj
     * @return true if two Location objects are equal, false otherwise
     */
    @Override
    public abstract boolean equals(Object obj);
}
