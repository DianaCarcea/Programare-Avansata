public class Road {
    public enum Roads{
        highways,express,country;
    }
    private Roads type;
    private double  length;
    int speedLimit;


    public Road(Roads type, double length, int speedLimit) {
        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;
    }

    public Roads getType() {
        return type;
    }

    public void setType(Roads type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    @Override
    public String toString() {
        return "Road{" +
                "type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }
}
