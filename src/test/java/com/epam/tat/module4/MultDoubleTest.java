package com.epam.tat.module4;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultDoubleTest {

    private Calculator calculator;
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Starting multiplication testing (Double)");

    }

    @DataProvider(name = "multiDoubleData")
    public Object[][] getMultDoubleData(){
        return new Object[][]  {

                //Happy path
                {20.0,10.0,200.0},
                {-10.1,-20.0,202.0},
                {100.9,-50.1,-5055.09},

                //Cero path
                {0.0,0.0,0.0},
                {0.0,50.0,0.0},
                {0.0,-50.0,0.0},
                {Double.MIN_VALUE,0.0,0.0},


                //Edge cases
                {Double.MAX_VALUE,Double.MAX_VALUE,Double.POSITIVE_INFINITY},
                {-Double.MAX_VALUE,-Double.MAX_VALUE,Double.POSITIVE_INFINITY},
                {Double.POSITIVE_INFINITY,100.0,Double.POSITIVE_INFINITY},
                {Double.MAX_VALUE,-Double.MAX_VALUE,Double.NEGATIVE_INFINITY}


        };
    }

    @Test(dataProvider = "multiDoubleData",groups = "arithmetic")
    public void testMultDouble(double a,double b, double expected){
        double result = calculator.mult(a,b);
        Assert.assertEquals(result,expected,0.000001,"The multiplication of "+a+" * "+b+" failed!");

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        calculator =null;
        System.out.println("Ended Testing for multiplication (Double)");

    }
}
