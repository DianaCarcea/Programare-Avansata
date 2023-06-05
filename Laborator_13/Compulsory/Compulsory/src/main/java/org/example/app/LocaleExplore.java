package org.example.app;

import org.example.com.SetLocale;
import org.example.com.Info;
import org.example.com.DisplayLocales;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplore {
    private static final String RESOURCE_BUNDLE = "res.Messages";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE);

        while (true) {
            System.out.print(resourceBundle.getString("prompt"));
            String command = scanner.nextLine().trim().toLowerCase();

            if (command.equals("locales")) {
                DisplayLocales displayLocales = new DisplayLocales();

                displayLocales.execute();

            } else if (command.equals("locale.set")) {
                System.out.print(resourceBundle.getString("locale.set"));
                String languageTag = scanner.nextLine().trim();
                SetLocale setLocale = new SetLocale();

                setLocale.execute(languageTag);


            } else if (command.equals("info")) {
                Locale currentLocale = Locale.getDefault();
                Info info = new Info();

                info.execute(currentLocale);

            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println(resourceBundle.getString("invalid"));
            }

            System.out.println();
        }

        scanner.close();
    }
}
