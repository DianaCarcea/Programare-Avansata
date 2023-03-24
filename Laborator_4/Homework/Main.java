package org.example;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Faker generator=new Faker();

        List<String> allStudentsName=new LinkedList();
        for(int nrStud=0;nrStud<5;nrStud++){
            allStudentsName.add(generator.name().firstName());
        }


        List<Set<String>> listPrefProj=new ArrayList<>();

        List<Student> allStudents= allStudentsName.stream()
                .map(name->new Student(name)).collect(Collectors.toList());

        List<String> allProjectsName=new LinkedList<>();
        for(int nrProj=0;nrProj<10;nrProj++)
        {
            allProjectsName.add(generator.company().profession());
        }


        Random rand = new Random();

        for(int nrStud=0;nrStud<allStudentsName.size();nrStud++)
        {
            Set<String> selectPref=new TreeSet<>();
            int nrProjChosen=rand.nextInt(allProjectsName.size())+1;
            for(int nrProj=0;nrProj<nrProjChosen;nrProj++){
                int posProj=rand.nextInt(nrProjChosen);
                selectPref.add(allProjectsName.get(posProj));
            }
            listPrefProj.add(selectPref);

        }
        System.out.println(listPrefProj);

        Preferences instance=new Preferences();
        int contor=0;
        for(Set<String> list :listPrefProj)
        {
            Set<Project> pref= list.stream()
                    .map(name->new Project(name)).collect(Collectors.toSet());

            instance.addInstance(allStudents.get(contor),pref);
            contor++;
        }
        double averagePreferences = listPrefProj.stream()
                .mapToInt(Set<String>::size)
                .average()
                .orElse(0);

        List<Student> studNrPrefLowerThanAvg = allStudents.stream()
                .filter(student -> {
                    int numberPrefStud = instance.getNumberOfPreferences(student);
                    return  numberPrefStud < averagePreferences;
                })
                .collect(Collectors.toList());

        System.out.println(averagePreferences);
        System.out.println(studNrPrefLowerThanAvg);
        System.out.println(instance);

        System.out.println("The allocation of student projects is:"+'\n');

        GreedyMatching alg=new GreedyMatching(instance);
        alg.assignmentProjects();
        System.out.println(alg.getAssignmentProjects());
    }

}