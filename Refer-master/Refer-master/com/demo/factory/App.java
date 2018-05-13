package com.demo.factory;

import java.io.IOException;

import com.demo.service.Accounting;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Accounting impl = EconomyFactory.getAccounting();
        try {
            impl.calculatePerCapita("/home/iid/TestFiles/input/input.csv", "/home/iid/TestFiles/output/output.csv");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
