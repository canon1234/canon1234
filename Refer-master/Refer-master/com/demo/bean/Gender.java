package com.demo.bean;

public enum Gender {

    Male("M"), Female("F");
    private String value;

    private Gender(String value) {
        this.value = value;
    }

}
