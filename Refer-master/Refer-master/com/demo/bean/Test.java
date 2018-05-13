package com.demo.bean;

public class Test {

    public static void main(String args[]) {

        CountryData c = new CountryData();
        c.setGender(Gender.Male);
        System.out.println(c.getGender().name());
    }
}
