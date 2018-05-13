package com.demo.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.demo.bean.OutputData;

public class FileWriting {
    //Delimiter used in CSV file

    private static final String COMMA_DELIMITER = ",";

    private static final String NEW_LINE_SEPARATOR = "\n";

    private static String FILE_HEADER = "countryName,gender,avgIncome";

    public static void writeFile(List<OutputData> listData, String fileName) {

        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
            //Write the CSV file header
            writer.append(FILE_HEADER.toString());
            //Add a new line separator after the header
            writer.append(NEW_LINE_SEPARATOR);

            for (OutputData d : listData) {
                writer.append(d.getCountryName());
                writer.append(COMMA_DELIMITER);
                writer.append(d.getGender().name());
                writer.append(COMMA_DELIMITER);
                writer.append(Integer.toString(d.getAvgIncome()));
                writer.append(COMMA_DELIMITER);
                writer.append(NEW_LINE_SEPARATOR);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
