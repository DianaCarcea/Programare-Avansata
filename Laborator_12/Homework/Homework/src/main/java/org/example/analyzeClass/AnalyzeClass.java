package org.example.analyzeClass;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class AnalyzeClass {
    public static void analyzeClass(Class<?> clazz) {
        String packageName = clazz.getPackage().getName();
        System.out.println("\n\nClass package: " + packageName);
        System.out.println("Class name: " + clazz.getSimpleName());

        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("Methods:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class) && Modifier.isPublic(method.getModifiers())) {

                System.out.println("\t" + method.getName());
            }
        }
    }
}
