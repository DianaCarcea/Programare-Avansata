/**
 *An instance of the "Best Route Problem" consists of locations and roads.
 *Two locations may be connected by a road, or not.
 *We consider the problem of determining the "best" route from one location to another.
*/

public class Main {
    /**
     * The main method
     * @param args
     */
    public static void main(String[] args) {
        Location iasi=new City("Iasi", "City",47.1585,27.6014,263410);
        Location pascani=new City("Pascani", "City",47.2411,26.7234,31568);
        Location targuFrumos=new City("Targu Frumos", "City",47.2085,27.0084,9386);
        Location poduIloaiei=new City("Podu Iloaiei", "City",47.2109,27.2665,8735);
        Location harlau=new City("Harlau", "City",47.4284, 26.9091,10055);

        Road iasiPascani=new Road(RoadType.EXPRESS,0.77770676,80);
        Road poduIloaieiHarlau=new Road(RoadType.HIGHWAY,50,100);
        Road pascaniTarguFrumos=new Road(RoadType.COUNTRY,15,50);

        Problem p=new Problem();
        p.addLocation(iasi);
        p.addLocation(harlau);
        p.addLocation(pascani);

        p.addRoad(iasiPascani,iasi,pascani);

        DepthFirstSearch algorithm=new DepthFirstSearch(p);
        algorithm.getBindingInfo(iasi,pascani);

    }
}