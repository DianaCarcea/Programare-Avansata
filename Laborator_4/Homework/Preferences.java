package org.example;

import java.util.*;

public class Preferences {
    private Map<Student, Set<Project>> prefMap=new HashMap<>();
    public void addInstance(Student student, Set<Project> projectsPref){
        prefMap.put(student,projectsPref);
    }

    public List<Student> getStudents(){
        List<Student> allStudents= new ArrayList<>();
        for(Student student : prefMap.keySet()){
            allStudents.add(student);
        }
        return allStudents;
    }

    public Set<Project> getProjects(){
        Set<Project> allProjects= new TreeSet<>();
        for(Student student : prefMap.keySet()){
            for(Project project : prefMap.get(student)){
                allProjects.add(project);
            }
        }
        return allProjects;
    }

    public int getNumberOfPreferences(Student student){
        return prefMap.get(student).size();

    }

    public Map<Student, Set<Project>> getPrefMap (){
        return prefMap;
    }

    @Override
    public String toString() {
        String result="";
        for(Student stud : prefMap.keySet())
        {
            result=result+stud.getName()+'\n';

            for (Project proj:prefMap.get(stud))
            {
                result=result+'\t'+proj+'\n';
            }
        }
        return result;
    }
}
