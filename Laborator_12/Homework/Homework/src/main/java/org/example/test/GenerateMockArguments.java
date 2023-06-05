package org.example.test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class GenerateMockArguments {
    public static Object[] generateMockArguments(Method method) {
        Parameter[] parameters = method.getParameters();
        Object[] args = new Object[parameters.length];

        for (int i = 0; i < parameters.length; i++) {

            Class<?> parameterType = parameters[i].getType();

            if (parameterType == int.class) {
                args[i] = 0;

            } else if (parameterType == String.class) {
                args[i] = "mock";

            } else {
                args[i] = null;

            }
        }
        return args;
    }
}
