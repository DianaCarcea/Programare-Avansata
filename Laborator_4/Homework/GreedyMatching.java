package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class GreedyMatching {
    private Preferences instance;
    private Map<Student,Project> assignedProject=new HashMap<>();
    private Set<Project> projectsAvailable=new TreeSet();

    public GreedyMatching(Preferences instance) {
        this.instance = instance;
        projectsAvailable=instance.getProjects();
    }

    public void assignmentProjects()
    {
        for (Student student: instance.getPrefMap().keySet())
        {
            for (Project project: instance.getPrefMap().get(student))
            {
                if(projectsAvailable.contains(project))
                {
                    assignedProject.put(student,project);
                    projectsAvailable.remove(project);
                    break;
                }
            }
        }
    }

    public String getAssignmentProjects()
    {
        String matching ="";
        for (Student student:assignedProject.keySet())
        {
            matching = matching +student.getName();
            matching=matching+'\n'+'\t' + "- Project: "+'\n'+'\t'+'\t';
            Project project=assignedProject.get(student);
            matching =matching + project.getName()+'\n';
        }

        return matching ;
    }
}
