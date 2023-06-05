package org.example.analyzeFile;

import java.io.File;

public class GetClassName {
    public static String getClassName(File file) {
        String filePath = file.getAbsolutePath();
        int classesIndex = filePath.lastIndexOf("classes");
        int startIndex = classesIndex + 8;
        int endIndex = filePath.lastIndexOf(".class");
        return filePath.substring(startIndex, endIndex).replace("\\", ".");
    }
}
