import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Person personOne=new Person("Stefan");
        Person personTwo=new Person("Ioana");

        if(personOne.compareTo(personTwo)==0) {
            System.out.println("The people have the same name!");
        }

        Company companyOne=new Company("Mambu");
        Company companyTwo=new Company("Bitdefender");

        List<Node> nodes=new ArrayList<>();

        nodes.add(personOne);
        nodes.add(companyOne);
        nodes.add(personTwo);
        nodes.add(companyTwo);

        for(Node person : nodes)
        {
            System.out.println(person.getName());
        }
    }
}