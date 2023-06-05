package org.example.com;

import java.util.Locale;

public class DisplayLocales {
    public void execute() {
        Locale[] availableLocales = Locale.getAvailableLocales();

        System.out.println("Locales available:");
        for (Locale locale : availableLocales) {
            System.out.println(locale.toString());
        }
    }
}