package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class outputHandlerImplTest {

    private outputHandler handler;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        List<Double> testList = new ArrayList<>();
        testList.add(1.0);
        testList.add(42.0);
        testList.add(99.0);
        Double exchangeRate = 3.407;
        handler = new outputHandlerImpl(testList, exchangeRate);

        System.setOut(new PrintStream(outContent));
    }

    @Test
    void print() {
        handler.print();
        assertEquals("3.407\r\n" +
                "143.094\r\n" +
                "337.293\r\n", outContent.toString());
    }


    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }


}