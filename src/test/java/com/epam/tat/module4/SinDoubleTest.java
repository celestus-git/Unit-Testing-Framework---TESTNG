package com.epam.tat.module4;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SinDoubleTest {
    private Calculator calculator;
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Starting Sin testing (Double)");

    }
    @DataProvider(name = "sinDoubleData")
    public Object[][] getSinDoubleData(){
        return new Object[][]{
                //Happy path
                {0.0,0.0},
                {Math.PI/2,1.0},
                {Math.PI,0.0},
                {3*Math.PI/2,-1.0},
                {2*Math.PI,0.0},
                {-Math.PI/2,-1.0},
                {-Math.PI,0.0},
                {-3*Math.PI/2,1.0},
                {-2*Math.PI,0.0},


                //Edge cases
                {Double.NaN,Double.NaN},
                {Double.POSITIVE_INFINITY,Double.NaN},

        };
    }
    @Test(dataProvider = "sinDoubleData",groups = "arithmetic")
    public void testSinDouble(double angle, double expected){
        double result = calculator.sin(angle);

        if (Double.isNaN(expected)){
            Assert.assertTrue(Double.isNaN(result),"It should launch NaN for the sin of "+angle);
        } else {
            Assert.assertEquals(result, expected, 0.000001, "The sin of " + angle + " failed!");
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        calculator =null;
        System.out.println("Ended Testing for sin (Double)");
    }
}
