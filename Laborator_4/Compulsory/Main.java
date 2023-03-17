import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        List<String> nameProject = Arrays.asList("Personal Trainer", "Smart Parking Lot", "Smart Booking", "Smart House Builder",
                                            "Social Media Aggregate","Bureaucracy Hacks","Music Generation");
        List<Project> projectList = nameProject.stream().map(name->new Project(name)).collect(Collectors.toList());

        List<String> nameStudents = Arrays.asList("Diana", "Andrei", "Stefan", "Maria");
        List<Student> studentList = nameStudents.stream().map(name->new Student(name)).collect(Collectors.toList());

        studentList.get(0).addProject(projectList.get(0));//Diana
        studentList.get(0).addProject(projectList.get(1));

        studentList.get(1).addProject(projectList.get(1));//Andrei
        studentList.get(1).addProject(projectList.get(3));
        studentList.get(1).addProject(projectList.get(4));

        studentList.get(2).addProject(projectList.get(2));//Stefan

        studentList.get(3).addProject(projectList.get(5));//Maria
        studentList.get(3).addProject(projectList.get(6));

        List <Student> allStudents=new LinkedList();
        for(Student student : studentList)
            allStudents.add(student);

        Set<Project> allProjects=new TreeSet<>();
        for(Project project : projectList)
            allProjects.add(project);

        Collections.sort(allStudents);

        for(Student student : allStudents)
            System.out.println(student);

        for(Project project : allProjects)
            System.out.println(project);

    }
}