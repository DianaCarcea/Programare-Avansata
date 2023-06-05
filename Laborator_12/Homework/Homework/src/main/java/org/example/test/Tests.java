package org.example.test;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.example.test.GenerateMockArguments.generateMockArguments;

public class Tests {

    public static void runTests(Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Method[] methods = clazz.getDeclaredMethods();
        int totalTests = 0;
        int passedTests = 0;
        int failedTests = 0;

        Object instance = clazz.getDeclaredConstructor().newInstance();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class) && Modifier.isPublic(method.getModifiers())) {
                try {
                    Object[] args = generateMockArguments(method);
                    if (Modifier.isStatic(method.getModifiers())) {
                        method.invoke(null, args);
                    } else {
                        method.invoke(instance, args);
                    }
                    System.out.println("Test '" + method.getName() + "' passed.");
                    passedTests++;
                } catch (Exception e) {
                    System.out.println("Test '" + method.getName() + "' failed: " + e.getMessage());
                    failedTests++;
                }
                totalTests++;
            }
        }

        System.out.println("\nTest Statistics:");
        System.out.println("Number of tests: " + totalTests);
        System.out.println("Number of passed tests: " + passedTests);
        System.out.println("Number of failed tests: " + failedTests);
    }
}
