package com.epam.tat.module4;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TgDoubleTest {

    private Calculator calculator;
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Starting Tan testing (Double)");

    }
    @DataProvider(name = "tanDoubleData")
    public Object[][] getTanDoubleData(){
        return new Object[][]{
                //Happy path

                {0.0,0.0},
                {Math.PI/6,0.5773502691896},
                {Math.PI/4,1.0},
                {-Math.PI/4,-1.0},
                {Math.PI/3,1.7320508075688},
                {2*Math.PI,0.0},


                //Edge cases
                {Double.NaN,Double.NaN},
                { 1.5707963267948966, Double.POSITIVE_INFINITY },

        };
    }
    @Test(dataProvider = "tanDoubleData",groups = "trigonometric")
    public void testTanDouble(double a, double expected){
        double result = calculator.tg(a);

            Assert.assertEquals(result, expected, 0.000001, "The sqrt of " + a + " failed!");

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        calculator =null;
        System.out.println("Ended Testing for tan (Double)");
    }
}
