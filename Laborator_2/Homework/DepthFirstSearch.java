/**
 *This class describes the DFS algorithm
 */
public class DepthFirstSearch {
    Problem instance;
    boolean []visit;

    /**
     * The DepthFirstSearch class constructor
     * @param instance
     */
    public DepthFirstSearch(Problem instance) {
        this.instance = instance;
        this.visit=new boolean[instance.countLocation];

    }

    /**
     * A DFS traversal from the start location to the end location is attempted.
     * @param startPosition
     * @param finalPosition
     */
    public void dfsAlgorithm(int startPosition,int finalPosition){
        visit[startPosition]=true;
        for(int indexLocation=0;indexLocation<instance.countLocation;indexLocation++){
            if(instance.roadBetweenLocation[startPosition][indexLocation]!=null && visit[indexLocation]==false){
                dfsAlgorithm(indexLocation,finalPosition);
            }
        }
    }

    /**
     * The method is checked if it is possible to get from one given location to another.
     * @param startPosition
     * @param finalPosition
     */
    public void getBindingInfo(Location startPosition,Location finalPosition){
        for(int i=0;i<instance.countLocation;i++){
            visit[i]=false;
        }

        dfsAlgorithm(instance.getPositionLocation(startPosition),instance.getPositionLocation(finalPosition));

        if(visit[instance.getPositionLocation(finalPosition)])
            System.out.println("It is possible to go from "+ startPosition.getName() + " to "+finalPosition.getName() +" using the given roads!");
        else
            System.out.println("It isn't possible to go from "+ startPosition.getName() + " to "+finalPosition.getName() +" using the given roads!");
    }
}
