package org.example.analyzeJar;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import static org.example.analyzeClass.AnalyzeClass.analyzeClass;
import static org.example.analyzeJar.GetClassNamesFromJar.getClassNamesFromJar;
import static org.example.test.Tests.runTests;

public class AnalyzeJarFile {
    public static void analyzeJarFile(File jarFile) {
        try {
            URL jarUrl = jarFile.toURI().toURL();
            URLClassLoader classLoader = new URLClassLoader(new URL[]{jarUrl});
            List<String> classNames = getClassNamesFromJar(jarFile);
            for (String className : classNames) {
                try {
                    Class<?> clazz = classLoader.loadClass(className);
                    analyzeClass(clazz);
                    runTests(clazz);
                } catch (ClassNotFoundException e) {
                    System.out.println("Failed to load the class: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to analyze the jar file: " + e.getMessage());
        }
    }
}
