package com.demo.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.demo.bean.CountryData;
import com.demo.bean.Gender;
import com.demo.bean.OutputData;
import com.demo.service.Accounting;
import com.demo.util.CountryComparator;
import com.demo.util.FileReading;
import com.demo.util.FileWriting;

public class AccountingImpl implements Accounting {

    public void calculatePerCapita(String inputFile, String outputFile) throws IOException {
        FileReading fr = new FileReading();
        List<CountryData> data = fr.readFile(inputFile);
        Collections.sort(data, new CountryComparator());
        List<OutputData> outputDataList = getOutputList(data);
        FileWriting.writeFile(outputDataList, outputFile);

    }

    public List<OutputData> getOutputList(List<CountryData> data) {
        String runningGroup = null;
        int runningCounter = 0;
        int totalIncome = 0;
        int avgIncome = 0;
        String runningcountryName = null;
        Gender runningGender = null;
        List<OutputData> outputDataList = new ArrayList<OutputData>();
        for (CountryData c : data) {
            String currentGroup = c.getCountryName() + c.getGender().name();
            if (runningGroup == null) {
                runningGroup = currentGroup;
            }
            if (runningGroup.equals(currentGroup)) {
                runningCounter++;
                totalIncome = totalIncome + c.getIncome();
                runningcountryName = c.getCountryName();
                runningGender = c.getGender();

            } else {
                avgIncome = totalIncome / runningCounter;
                OutputData d = new OutputData();
                d.setCountryName(runningcountryName);
                d.setGender(runningGender);
                d.setAvgIncome(avgIncome);
                outputDataList.add(d);
                totalIncome = c.getIncome();
                runningcountryName = c.getCountryName();
                runningGender = c.getGender();
                runningCounter = 1;
                runningGroup = currentGroup;
                avgIncome = 0;
            }

        }
        avgIncome = totalIncome / runningCounter;
        OutputData d = new OutputData();
        d.setCountryName(runningcountryName);
        d.setGender(runningGender);
        d.setAvgIncome(avgIncome);
        outputDataList.add(d);
        return outputDataList;
    }

}
