package com.epam.tat.module4;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CtgDoubleTest {

    private Calculator calculator;
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Starting Cotang testing (Double)");

    }
    @DataProvider(name = "cotanDoubleData")
    public Object[][] getCotanDoubleData(){
        return new Object[][]{


                {Math.PI / 4, 1.0},
                {Math.PI / 2, 0.0},
                {0.0, Double.POSITIVE_INFINITY},
                {Math.PI / 6, 1.73205081},
                {Double.NaN, Double.NaN},


        };
    }
    @Test(dataProvider = "cotanDoubleData",groups = "trigonometric")
    public void testCotanDouble(double a, double expected){
        double result = calculator.ctg(a);

        Assert.assertEquals(result, expected, 0.000001, "The sqrt of " + a + " failed!");

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        calculator =null;
        System.out.println("Ended Testing for cotang (Double)");
    }
}
