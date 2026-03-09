package com.epam.tat.module4;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class isNegativeBooleanTest {
    private Calculator calculator;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Starting isNegative testing (Long)");

    }

    @DataProvider(name = "isNegativeLongData")
    public Object[][] getIsNegativeLongData() {
        return new Object[][]{

                {-100, true},
                {50, false},
                {0, false}
        };
    }

    @Test(dataProvider = "isNegativeLongData", groups = "logic")
    public void testIsNegativeDouble(long a, boolean expected) {
        boolean result = calculator.isNegative(a);
        if (expected) {
            Assert.assertTrue(result, "Error: " + a + "must be negative!");

        } else {
            Assert.assertFalse(result, "Error: " + a + "must not be negative!");
        }

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        calculator = null;
        System.out.println("Ended Testing for isNegative (Long)");
    }
}
