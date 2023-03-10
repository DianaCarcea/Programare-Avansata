public class Person implements Node, Comparable<Person>{
    String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int compareTo(Person other) {
        if(other==null)
        {
            throw new NullPointerException();
        }
        return this.name.compareTo(other.name);
    }
}
