package org.example.analyzeFile;

import java.io.File;


import static org.example.analyzeClass.AnalyzeClass.analyzeClass;
import static org.example.analyzeClass.LoadClass.loadClass;
import static org.example.analyzeFile.GetClassName.getClassName;
import static org.example.test.Tests.runTests;

public class AnalyzeDirectory {
    public static void analyzeDirectory(File directory) {
        File[] files = directory.listFiles();


        if (files != null) {
            for (File file : files) {

                if (file.isDirectory()) {
                    analyzeDirectory(file);

                } else if (file.isFile() && file.getName().endsWith(".class")) {
                    try {
                        String className = getClassName(file);
                        Class<?> clazz = loadClass(className, file);//incarc clasa
                        analyzeClass(clazz);//analizez clasa
                        runTests(clazz);//testez metode din clasa

                    } catch (ClassNotFoundException e) {

                        System.out.println("Failed to load class: " + e.getMessage());

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
