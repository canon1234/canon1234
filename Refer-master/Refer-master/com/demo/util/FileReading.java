package com.demo.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.demo.bean.CountryData;
import com.demo.bean.CurrencyEnum;
import com.demo.bean.Gender;

public class FileReading {

    public List<CountryData> readFile(String inputFile) throws IOException {
        String line = null;
        BufferedReader stream = null;
        List<CountryData> csvData = new ArrayList<CountryData>();
        CurrencyEnum currency = null;
        int income;
        try {
            stream = new BufferedReader(new FileReader(inputFile));
            line = stream.readLine();
            while ((line = stream.readLine()) != null) {
                String[] splitted = line.split(",");
                CountryData data = new CountryData();
                data.setCountryName(splitted[0]);
                data.setCityName(splitted[1]);
                data.setGender(Gender.valueOf(splitted[2]));
                currency = CurrencyEnum.valueOf(splitted[4]);
                data.setCurrency(currency);
                income = Integer.parseInt(splitted[3]) / currency.getValue();
                data.setIncome(income);
                csvData.add(data);

            }
        } finally {
            if (stream != null)
                try {
                    stream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        return csvData;
    }

}
