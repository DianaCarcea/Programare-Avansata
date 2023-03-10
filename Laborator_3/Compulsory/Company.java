public class Company implements Node, Comparable<Company> {
    String name;
    public Company(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int compareTo(Company other) {
        if(other==null)
        {
            throw new NullPointerException();
        }
        return this.name.compareTo(other.name);
    }
}
