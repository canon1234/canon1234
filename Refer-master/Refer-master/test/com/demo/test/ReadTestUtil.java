package com.demo.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.demo.bean.CurrencyEnum;
import com.demo.bean.Gender;
import com.demo.bean.OutputData;

public class ReadTestUtil {

    public List<OutputData> readFile(String inputFile) {
        String line = null;
        BufferedReader stream = null;
        List<OutputData> csvData = new ArrayList<OutputData>();
        CurrencyEnum currency = null;
        int income;
        try {
            stream = new BufferedReader(new FileReader(inputFile));
            line = stream.readLine();
            while ((line = stream.readLine()) != null) {
                String[] splitted = line.split(",");
                OutputData data = new OutputData();
                data.setCountryName(splitted[0]);
                data.setGender(Gender.valueOf(splitted[1]));
                data.setAvgIncome(Integer.parseInt(splitted[2]));
                csvData.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
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
