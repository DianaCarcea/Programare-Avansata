package org.example.com;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class Info {
    public void execute(Locale locale) {
        String country=null;
        country = locale.getDisplayCountry(locale);
        String language = locale.getDisplayLanguage(locale);
        Currency currency = null;


        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] months = dateFormatSymbols.getMonths();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy", locale);
        String today = dateFormat.format(calendar.getTime());


        if(country.length()!=0)
            System.out.println("Country: " + country);
        else
            System.out.println("Country not available for locale: " + locale);

        System.out.println("Language: " + language);


        try {
            currency = Currency.getInstance(locale);
            System.out.println("Currency: " + currency.getCurrencyCode() + " (" + currency.getDisplayName(locale) + ")");
        } catch (IllegalArgumentException e) {
            System.out.println("Currency not available for locale: " + locale);
        }


        System.out.println("Week Days: " + String.join(", ", weekdays));
        System.out.println("Months: " + String.join(", ", months));
        System.out.println("Today: " + today);
    }
}