package com.epam.tat.module4;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivDoubleTest {


    private Calculator calculator;
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Starting division testing (Double)");

    }

    @DataProvider(name = "divDoubleData")
    public Object[][] getDivDoubleData(){
        return new Object[][]  {

                //Happy path

                {20.0,10.0,2.0},
                {-10.0,-5.0,2.0},
                {10.0,-5.0,-2.0},

                //Truncated path

                {10,3,3.333333333333333},
                {5.0,2.0,2.5},
                {0.0,10.0,0.0},


                //Edge cases
                {10.0,0.0,Double.POSITIVE_INFINITY},
                {-10.0,0.0,Double.NEGATIVE_INFINITY},
                {0.0,0.0,Double.NaN},

        };
    }

    @Test(dataProvider = "divDoubleData",groups = "arithmetic")
    public void testDivDouble(double a,double b, double expected){
        double result = calculator.div(a,b);
        Assert.assertEquals(result,expected,0.0001,"The division of "+a+" / "+b+" failed!");

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        calculator =null;
        System.out.println("Ended Testing for division (Double)");

    }


}
