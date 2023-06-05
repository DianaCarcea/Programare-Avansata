package org.example;
import java.io.File;

import static org.example.analyzeFile.AnalyzeDirectory.analyzeDirectory;
import static org.example.analyzeJar.AnalyzeJarFile.analyzeJarFile;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Directory or jar as input is missing.");
            return;
        }
        //The input may be a folder (containing .class files) or a .jar. You must explore it recursively.
        String path = args[0];
        File file = new File(path);
        if (file.isDirectory()) {
            analyzeDirectory(file);

        } else if (file.isFile() && file.getName().endsWith(".jar")) {
            analyzeJarFile(file);

        } else {
            System.out.println("Invalid file.");
        }
    }



}
