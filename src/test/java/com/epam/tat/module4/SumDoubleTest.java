package com.epam.tat.module4;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumDoubleTest {

    private Calculator calculator;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
    calculator = new Calculator();
        System.out.println("Starting sum testing (Double)");
    }

    @DataProvider(name = "sumDoubleData")
    public Object[][] getSumDoubleData(){
        return new Object[][]{
                //Happy path
                {10.0,20.1,30.1},
                {-100.1,-200.1,-300.2},
                {100.5,-50.1,50.4},

                //Cero path
                {Double.MIN_VALUE,0.0,Double.MIN_VALUE},
                {0.0,-0.0,0.0},

                //Edge cases
                {Double.MAX_VALUE,Double.MAX_VALUE,Double.POSITIVE_INFINITY},
                {-Double.MAX_VALUE,-Double.MAX_VALUE,Double.NEGATIVE_INFINITY},
                {Double.POSITIVE_INFINITY,100.0,Double.POSITIVE_INFINITY}
        };
    }
    @Test(dataProvider = "sumDoubleData",groups = "arithmetic")
    public void testSumDouble(Double a,Double b,Double expected){
        Double result = calculator.sum(a,b);
        Assert.assertEquals(result,expected,"The sum of "+a+" + "+b+" failed!");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
calculator=null;
        System.out.println("Ended Testing for sum (Double)");
    }
}
