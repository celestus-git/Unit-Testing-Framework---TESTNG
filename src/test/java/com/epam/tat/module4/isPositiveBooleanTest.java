package com.epam.tat.module4;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class isPositiveBooleanTest {
    private Calculator calculator;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Starting isPositive testing (Long)");

    }

    @DataProvider(name = "isPositiveLongData")
    public Object[][] getIsPositiveLongData() {
        return new Object[][]{

                {10, true},
                {-5, false},
                {0, false}
        };
    }

    @Test(dataProvider = "isPositiveLongData", groups = "logic")
    public void testIsPositiveDouble(long a, boolean expected) {
        boolean result = calculator.isPositive(a);
        if (expected) {
            Assert.assertTrue(result, "Error: " + a + "must be positive!");

        } else {
            Assert.assertFalse(result, "Error: " + a + "must not be positive!");
        }

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        calculator = null;
        System.out.println("Ended Testing for isPositive (Long)");
    }
}
