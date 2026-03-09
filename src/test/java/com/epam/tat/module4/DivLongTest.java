package com.epam.tat.module4;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivLongTest {

    private Calculator calculator;
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Starting division testing (Long)");

    }

    @DataProvider(name = "divLongData")
    public Object[][] getDivLongData(){
        return new Object[][]  {

                //Happy path

                {20,10,2},
                {-10,-5,2},
                {10,-5,-2},

                //Truncated path

                {10,3,3},
                {5,2,2},
                {0,10,0},


                //Edge cases
                {Long.MAX_VALUE,1,Long.MAX_VALUE},
                {Long.MIN_VALUE,1,Long.MIN_VALUE},

        };
    }

    @Test(dataProvider = "divLongData",groups = "arithmetic")
    public void testDivLong(long a,long b, long expected){
        long result = calculator.div(a,b);
        Assert.assertEquals(result,expected,"The division of "+a+" / "+b+" failed!");

    }
    @Test(expectedExceptions = NumberFormatException.class,
    expectedExceptionsMessageRegExp = "Attempt to divide by zero",
    groups = "arithmetic")
    public void testDivByZero(){
        calculator.div(10L,0L);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        calculator =null;
        System.out.println("Ended Testing for division (Long)");

    }


}
