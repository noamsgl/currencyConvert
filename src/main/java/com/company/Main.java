package com.company;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        String fname = args[0];

        fileHandler fhandler = new fileHandlerImpl(fname);

        String baseCurrency = fhandler.getFromCurrency();
        String toCur = fhandler.getToCurrency();
        List<Double> values = fhandler.getValues();

        ExchangeRateAPI api = new ExchangeRateAPIImpl(baseCurrency);
        Double exchangeRate = api.getExchangeRate(toCur);

        outputHandler outPutHandler = new outputHandlerImpl(values, exchangeRate);

        outPutHandler.print();

    }
}
