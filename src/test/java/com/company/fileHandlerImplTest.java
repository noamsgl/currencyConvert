package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class fileHandlerImplTest {

    private fileHandler handler;

    @BeforeEach
    void setUp() {
        handler = new fileHandlerImpl("Testinput.txt");
    }

    @Test
    void getFromCurrency() {
        assertEquals(handler.getFromCurrency(), "USD");
    }

    @Test
    void getToCurrency() {
        assertEquals(handler.getToCurrency(), "ILS");
    }

    @Test
    void getValues() {
        List<Double> testList = new ArrayList<>();
        testList.add(1.0);
        testList.add(5.0);
        testList.add(10.5);
        assertEquals(handler.getValues(), testList);
    }
}