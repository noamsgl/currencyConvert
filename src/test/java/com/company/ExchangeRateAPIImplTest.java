package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExchangeRateAPIImplTest {

    @Test
    void setBaseCurrencyCode() {
        ExchangeRateAPI api = new ExchangeRateAPIImpl("USD");
        api.setBaseCurrencyCode("ILS");
        assertEquals(api.getBaseCurrencyCode(), "ILS");
        api.setBaseCurrencyCode("AED");
        assertEquals(api.getBaseCurrencyCode(), "AED");
    }

    @Test
    void getExchangeRate() {
        ExchangeRateAPI api = new ExchangeRateAPIImpl("USD");
        //test some other api
    }

    @Test
    void getExchangeRates() {
        ExchangeRateAPI api = new ExchangeRateAPIImpl("USD");
        //test some other api
    }
}