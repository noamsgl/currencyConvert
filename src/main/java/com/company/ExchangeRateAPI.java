package com.company;

import java.util.Map;

public interface ExchangeRateAPI {

    public void setBaseCurrency(String currencyCode);

    //    return the exchange rate from base currency to variable currency
    public Double getExchangeRate(String currencyCode);

    //    return a mapping from currency codes to exchange rates
    public Map<String, Double> getExchangeRates();

}
