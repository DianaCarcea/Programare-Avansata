package org.example;

import org.example.MyClassLoader;
import org.junit.Test;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader myLoader1 = new MyClassLoader();
        Class<?> targetClass = myLoader1.loadClass("org.example.MyProgram");


        Package pkg = targetClass.getPackage();
        String packageName = pkg != null ? pkg.getName() : "Default Package";
        System.out.println("Package: " + packageName);


        System.out.println("Class: " + targetClass.getName());

        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());

            Annotation testAnnotation = method.getAnnotation(Test.class);
            if (testAnnotation != null && method.getParameterCount() == 0 && Modifier.isStatic(method.getModifiers())) {
                try {
                    method.invoke(null);
                    System.out.println("Invoked method: " + method.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
