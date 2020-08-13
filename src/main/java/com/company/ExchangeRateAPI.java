package com.company;

import java.util.Map;

public interface ExchangeRateAPI {

    void setBaseCurrencyCode(String currencyCode);

    String getBaseCurrencyCode();

    //    return the exchange rate from base currency to variable currency
    Double getExchangeRate(String currencyCode);

    //    return a mapping from currency codes to exchange rates
    Map<String, Double> getExchangeRates();

}
