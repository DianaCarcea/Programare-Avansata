public class Main {
    public static void main(String[] args) {
        Location l1=new Location("Sihastria Putna", Location.Locations.monastery,47.8677,25.6028);
        Road r1=new Road(Road.Roads.express,15,80);

        Location l2=new Location("Iasi", Location.Locations.city,47.17,27.57);
        Road r2=new Road(Road.Roads.country,9,50);

        System.out.println(l1.getName()+" " + l1.getType()+ " is located at coordinates (" + l1.getCoordinate_x()+","+l1.getCoordinate_y()+") on the map of Romania.");
        System.out.println("On the " + r1.getType()+" road with the length of "+r1.getLength()+ " KM you can drive at a maximum speed of" + r1.getSpeedLimit()+ " KM/H.");

        System.out.print("\n");

        System.out.println(l2);
        System.out.println(r2);
    }
}