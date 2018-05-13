package com.demo.util;

import java.util.Comparator;

import com.demo.bean.CountryData;

public class CountryComparator implements Comparator {

    public int compare(Object o1, Object o2) {
        // TODO Auto-generated method stub
        CountryData c1 = (CountryData) o1;
        CountryData c2 = (CountryData) o2;
        int compareCountry = c1.getCountryName().compareTo(c2.getCountryName());
        int compareGender = c1.getGender().name().compareTo(c2.getGender().name());
        if (compareCountry == 0) {
            return compareGender;
        } else {
            return compareCountry;
        }
    }

}
