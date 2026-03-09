package com.epam.tat.module4;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SqrtDoubleTest {
    private Calculator calculator;
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Starting sqrt testing (Double)");

    }
    @DataProvider(name = "sqrtDoubleData")
    public Object[][] getSqrtDoubleData(){
        return new Object[][]{
                //Happy path
                {25.0,5.0},
                {2.0,1.4142135623730951},

                //Cero path
                {Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY},
                {0.0,0.0},

                //Edge cases
                {-1.0,Double.NaN},
                {Double.NEGATIVE_INFINITY,Double.NaN},

        };
    }
    @Test(dataProvider = "sqrtDoubleData",groups = "arithmetic")
    public void testSqrtDouble(double a, double expected){
        double result = calculator.sqrt(a);

        if (Double.isNaN(expected)){
            Assert.assertTrue(Double.isNaN(result),"It should launch NaN for the sqrt of "+a);
        } else {
            Assert.assertEquals(result, expected, 0.000001, "The sqrt of " + a + " failed!");
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        calculator =null;
        System.out.println("Ended Testing for sqrt (Double)");
    }
}
