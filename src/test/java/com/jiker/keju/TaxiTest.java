package com.jiker.keju;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TaxiTest {
    @Test
    public void test() {
        Taxi taxi = new Taxi();
        assertNotNull(taxi);
    }

    @Test
    public void test_charge() {
        Taxi taxi = new Taxi();
        assertEquals(taxi.charge(new BigDecimal("1"), new BigDecimal("0")), new BigDecimal("6"));
        assertEquals(taxi.charge(new BigDecimal("3"), new BigDecimal("0")), new BigDecimal("7"));
        assertEquals(taxi.charge(new BigDecimal("10"), new BigDecimal("0")), new BigDecimal("13"));
        assertEquals(taxi.charge(new BigDecimal("2"), new BigDecimal("3")), new BigDecimal("7"));
    }

    @Test
    public void test_readwrite() {
        Taxi taxi = new Taxi();
        assertEquals(taxi.text("1公里,等待0分钟\n"), new BigDecimal("6"));
        assertEquals(taxi.text("3公里,等待0分钟\n"), new BigDecimal("7"));
        assertEquals(taxi.text("10公里,等待0分钟\n"), new BigDecimal("13"));
        assertEquals(taxi.text("2公里,等待3分钟\n"), new BigDecimal("7"));
    }
}
