package com.demo.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.demo.bean.CountryData;
import com.demo.bean.CurrencyEnum;
import com.demo.bean.Gender;
import com.demo.bean.OutputData;
import com.demo.serviceimpl.AccountingImpl;

public class TestService2 {

    private static ReadTestUtil reader;

    private static AccountingImpl accountingImpl;

    @BeforeClass
    public static void initClass() {
        accountingImpl = new AccountingImpl();
        System.out.println("Starting test case");
        reader = new ReadTestUtil();

    }

    @Before
    public void init() {

    }

    @Test
    public void testMainFlow() {

        String inputFile = "/home/iid/demo/BusinessService/src/test/java/com/demo/test/resources/input.csv";
        String outputFile = "/home/iid/demo/BusinessService/src/test/java/com/demo/test/resources/output.csv";
        try {
            accountingImpl.calculatePerCapita(inputFile, outputFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<OutputData> listData = reader.readFile(outputFile);
        assertEquals(3, listData.size());

    }

    @Test
    public void testOutputData() {
        List<CountryData> cd = dummyData();
        List<OutputData> od = accountingImpl.getOutputList(cd);
        assertEquals(2, od.size());
        OutputData od1 = od.get(0);
        OutputData od2 = od.get(1);
        assertEquals("India", od1.getCountryName());
        assertEquals(Gender.Female, od1.getGender());
        assertEquals(20, od1.getAvgIncome());

    }

    @Test(expected = IOException.class)
    public void testFileNotFoundFlow() throws IOException {

        String inputFile = "/home/iid/demo/BusinessService/src/test/java/com/demo/test/resources/abc.csv";
        String outputFile = "/home/iid/demo/BusinessService/src/test/java/com/demo/test/resources/output.csv";
        accountingImpl.calculatePerCapita(inputFile, outputFile);

    }

    private List<CountryData> dummyData() {
        List<CountryData> cd = new ArrayList<CountryData>();
        CountryData c = new CountryData();
        c.setCountryName("India");
        c.setGender(Gender.Female);
        c.setCurrency(CurrencyEnum.INR);
        c.setIncome(20);
        c.setCityName("Delhi");
        cd.add(c);

        CountryData c1 = new CountryData();
        c1.setCountryName("US");
        c1.setGender(Gender.Male);
        c1.setCurrency(CurrencyEnum.USD);
        c1.setIncome(20);
        c1.setCityName("Newyork");
        cd.add(c1);

        return cd;
    }

}
