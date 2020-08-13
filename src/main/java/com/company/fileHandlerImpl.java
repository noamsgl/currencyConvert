package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class fileHandlerImpl implements fileHandler {

    private String fromCur;
    private String toCur;
    private List<Double> values;

    public fileHandlerImpl(String fname) {
        BufferedReader reader;
        values = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(fname));
            fromCur = reader.readLine();
            toCur = reader.readLine();
            String line = reader.readLine();
            while (line != null) {
                Double currentValue = Double.parseDouble(line);
                values.add(currentValue);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFromCurrency() {
        return fromCur;
    }

    @Override
    public String getToCurrency() {
        return toCur;
    }

    @Override
    public List<Double> getValues() {
        return values;
    }
}
