package org.example;

import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader extends URLClassLoader {
    //Salvez clasa in memorie
    public MyClassLoader() {
        super(new URL[0], ClassLoader.getSystemClassLoader());
    }
}