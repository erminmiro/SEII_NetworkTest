package com.example.networktest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void checkSumDigitCheckTest() {
        QuerSum querSum = new QuerSum("11834110");
        assertEquals(8,querSum.getDigit(2));
    }

    @Test
    public void checkSumCalculateTest() {
        QuerSum querSum = new QuerSum("11834110");
        querSum.calculateQuerSum();
        assertEquals(-7,querSum.getSum());
    }
}