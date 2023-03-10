import java.lang.Math;

/**
 * This class describes an instance of the problem
 */
public class Problem {
    private Location[] locations;
    Road[][] roadBetweenLocation;
    int countLocation;
    int countRoad;

    /**
     * The problem class constructor
     */
    public Problem() {
        locations=new Location[15];
        roadBetweenLocation=new Road[15][15];
        countLocation=0;
        countRoad=0;
    }

    /**
     * The method that obtains the position of a location from the matrix roadBetweenLocation
     * @param location
     * @return the position of the location if it already exists, otherwise -1
     */
    public int getPositionLocation(Location location){
        for(int i=0;i<countLocation;i++)
        {
            if (locations[i].equals(location))
                return i;
        }
        return -1;
    }

    /**
     *The method that adds a location to the roadBetweenLocation matrix
     * @param location
     */
    public void addLocation(Location location){
        if(getPositionLocation(location)==-1) {
            locations[countLocation] = location;
            countLocation++;
        }
    }

    /**
     * This method calculates the distance between two locations by applying the mathematical distance formula.
     * @param firstLocation
     * @param secondLocation
     * @return the distance of the locations that are given as a parameter
     */
    public double distanceBetweenTwoLocations(Location firstLocation,Location secondLocation){
        return Math.sqrt(Math.pow(firstLocation.getCoordinate_x()- secondLocation.getCoordinate_x(),2)-
                         Math.pow(firstLocation.getCoordinate_y()- secondLocation.getCoordinate_y(),2));
    }

    /**
     *The method that verifies the possibility of adding a road between locations
     * @param road
     * @param firstLocation
     * @param secondLocation
     * @return true if the road between the two locations can be added, false otherwise
     */

    public boolean locationConnectionCheck(Road road,Location firstLocation,Location secondLocation){
        if(getPositionLocation(firstLocation)==-1 || getPositionLocation(secondLocation)==-1){
            System.out.println("A location does not exist to be connected by a road!");
            System.exit(-1);
        }
        if(distanceBetweenTwoLocations(firstLocation,secondLocation)<road.getLength()){
            System.out.println("The length of a road is less than the Euclidean distance between locations!");
            System.exit(-1);
        }
        return true;
    }

    /**
     *The method that adds the road between locations in the road matrix: roadBetweenLocation[][]
     * @param road
     * @param firstLocation
     * @param secondLocation
     */
    public void addRoad(Road road,Location firstLocation,Location secondLocation) {
        if (locationConnectionCheck(road, firstLocation, secondLocation)) {
            roadBetweenLocation[getPositionLocation(firstLocation)][getPositionLocation(secondLocation)] = road;
            roadBetweenLocation[getPositionLocation(secondLocation)][getPositionLocation(firstLocation)] = road;
        }
    }

}
