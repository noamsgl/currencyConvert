package com.company;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.EnumUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class ExchangeRateAPIImpl implements ExchangeRateAPI {
    private String baseCurrencyCode;
    private Map<String, Double> exchangeRates;

    enum curencyCodes {
        AED, ARS, AUD, BGN, BRL,
        BSD, CAD, CHF, CLP, CNY,
        COP, CZK, DKK, DOP,
        EGP, EUR, FJD, GBP,
        GTQ, HKD, HRK, HUF,
        IDR, ILS, INR, ISK,
        JPY, KRW, KZT, MVR,
        MXN, MYR, NOK, NZD,
        PAB, PEN, PHP, PKR,
        PLN, PYG, RON, RUB,
        SAR, SEK, SGD, THB,
        TRY, TWD, UAH, USD,
        UYU, ZAR
    }

    public ExchangeRateAPIImpl(String currencyCode) {
        this.baseCurrencyCode = currencyCode;
//              Check that currency codes are valid.
        if (!isLegalCurrencyCode(currencyCode)) {
            throw new IllegalArgumentException("\nOne of the currency codes you entered is invalid." +
                    "\nSee https://www.exchangerate-api.com/docs/supported-currencies for supported currencies.");
        }
        try {
//              Connect to exchangerate-api.com
            URL url = new URL("https://v6.exchangerate-api.com/v6/859af92d68e381d006118e92/latest/" + currencyCode);
            URLConnection request = url.openConnection();
            request.connect();

//              Parse Json and extract exchange rates
            Gson gson = new Gson();
            JsonObject root = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent())).getAsJsonObject();
            Type mapType = new TypeToken<Map<String, Double>>() {
            }.getType();
            exchangeRates = gson.fromJson(root.get("conversion_rates"), mapType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseCurrencyCode() {
        return baseCurrencyCode;
    }

    public void setBaseCurrencyCode(String baseCurrencyCode) {
        this.baseCurrencyCode = baseCurrencyCode;
    }

    @Override
    public Double getExchangeRate(String currencyCode) {
        if (!isLegalCurrencyCode(currencyCode)) {
            throw new IllegalArgumentException("\n The currency code you entered is invalid." +
                    "\nSee https://www.exchangerate-api.com/docs/supported-currencies for supported currencies.");
        }
        return exchangeRates.get(currencyCode);
    }

    @Override
    public Map<String, Double> getExchangeRates() {
        return exchangeRates;
    }

    private static boolean isLegalCurrencyCode(String currencyCode) {
        return EnumUtils.isValidEnum(curencyCodes.class, currencyCode);
    }

}
