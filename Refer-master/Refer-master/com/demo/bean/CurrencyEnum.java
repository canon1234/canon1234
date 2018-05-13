package com.demo.bean;

public enum CurrencyEnum {

    USD(1), INR(2);
    private int value;

    private CurrencyEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
