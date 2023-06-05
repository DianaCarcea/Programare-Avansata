package org.example.analyzeJar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class GetClassNamesFromJar {
    public static List<String> getClassNamesFromJar(File jarFile) {
        List<String> classNames = new ArrayList<>();

        try (JarFile jar = new JarFile(jarFile)) {
            Enumeration<JarEntry> entries = jar.entries();

            while (entries.hasMoreElements()) {

                JarEntry entry = entries.nextElement();
                if (entry.getName().endsWith(".class")) {

                    String className = entry.getName().replace('/', '.');
                    classNames.add(className.substring(0, className.length() - ".class".length()));
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to read the jar file: " + e.getMessage());
        }

        return classNames;
    }
}
