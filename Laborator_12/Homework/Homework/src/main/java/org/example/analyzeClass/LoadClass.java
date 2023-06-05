package org.example.analyzeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class LoadClass {
    public static Class<?> loadClass(String className, File file) throws ClassNotFoundException, MalformedURLException {

        URLClassLoader classLoader = new URLClassLoader(new URL[]{file.getParentFile().toURI().toURL()});
        return classLoader.loadClass(className);
    }
}
