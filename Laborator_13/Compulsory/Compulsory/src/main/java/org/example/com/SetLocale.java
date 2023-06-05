package org.example.com;

import java.util.Locale;

public class SetLocale {
    public void execute(String languageTag) {
        Locale locale = Locale.forLanguageTag(languageTag);
        Locale.setDefault(locale);

        System.out.println("Current locale set to: " + locale.toString());
    }
}