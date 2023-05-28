package org.example;

import org.junit.Test;

public class MyProgram {
    @Test
    public static void m1() {
        System.out.println("Afisare din m1");
    }
    public static void m2() {
        System.out.println("Afisare din m2");
    }
    @Test public static void m3() {
        throw new RuntimeException("Boom");
    }
    public static void m4() {
        System.out.println("Afisare din m4");
    }
    @Test public static void m5() {
        System.out.println("Afisare din m5");
    }
    public static void m6() {
        System.out.println("Afisare din m6");
    }
    @Test public static void m7() {
        throw new RuntimeException("Crash");
    }
    public static void m8() {
        System.out.println("Afisare din m8");
    }
}
