import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student>{
    String name;
    List<Project> listProjects=new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getListProjects() {
        return listProjects;
    }

    public void setListProjects(List<Project> listProjects) {
        this.listProjects = listProjects;
    }

    public void addProject(Project o){
        listProjects.add(o);
    }

    @Override
    public String toString() {
        String result=name+'\n'+"Projects:\n";
        for(Project proj : listProjects)
        {
            result=result+'\t'+proj.getName()+'\n';
        }
        return result;

    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.getName());
    }
}
