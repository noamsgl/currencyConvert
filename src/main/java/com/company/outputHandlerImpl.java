package com.company;

import java.util.List;

public class outputHandlerImpl implements outputHandler {
    private List<Double> values;
    private Double exchangeRate;

    public outputHandlerImpl(List<Double> values, Double exchangeRate) {
        this.values = values;
        this.exchangeRate = exchangeRate;
    }

    @Override
    public void print() {
        for (Double val : values) {
            System.out.println(val * exchangeRate);
        }
    }
}
