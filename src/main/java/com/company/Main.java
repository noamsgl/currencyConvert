package com.company;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        String fname = args[0];

        //Read data from input file
        fileHandler fhandler = new fileHandlerImpl(fname);
        String baseCurrency = fhandler.getFromCurrency();
        String toCur = fhandler.getToCurrency();
        List<Double> values = fhandler.getValues();

        //Get exchange rate from API
        ExchangeRateAPI api = new ExchangeRateAPIImpl(baseCurrency);
        Double exchangeRate = api.getExchangeRate(toCur);

        //Print converted values to System.out
        outputHandler outPutHandler = new outputHandlerImpl(values, exchangeRate);
        outPutHandler.print();
    }
}
