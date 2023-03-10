import java.util.Objects;

/**
 * The class that describes a road
 */
public class Road {
    private RoadType type;
    private double  length;
    int speedLimit;

    /**
     * The Road class constructor
     * @param type
     * @param length
     * @param speedLimit
     */
    public Road(RoadType type, double length, int speedLimit) {
        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;
    }

    /**
     * @return the type of the road
     */
    public RoadType getType() {
        return type;
    }

    /**
     * The type of the road is set
     * @param type
     */
    public void setType(RoadType type) {
        this.type = type;
    }

    /**
     * @return the length of the road
     */
    public double getLength() {
        return length;
    }

    /**
     * The length of the road is set
     * @param length
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * @return the speed limit of the road
     */
    public int getSpeedLimit() {
        return speedLimit;
    }

    /**
     * The speed limit of the road is set
     * @param speedLimit
     */
    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    /**
     * @return a representation of the Road object information
     */
    @Override
    public String toString() {
        return "Road{" +
                "type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }

    /**
     * @param o
     * @return true if two Road objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return Double.compare(road.length, length) == 0 && speedLimit == road.speedLimit && type == road.type;
    }

}
