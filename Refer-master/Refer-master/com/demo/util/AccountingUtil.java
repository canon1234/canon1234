package com.demo.util;

public class AccountingUtil {

    public static String findCountryName(String cityName) {

        if (cityName.equalsIgnoreCase("New Delhi")) {
            return "India";
        } else {
            return cityName;
        }
    }

}
