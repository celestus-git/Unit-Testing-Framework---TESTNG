package com.epam.tat.module4;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultLongTest {
    private Calculator calculator;
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Starting multiplication testing (Long)");

    }
    @DataProvider(name = "multLongData")
    public Object[][] getmultLongData(){
        return new Object[][]  {

                //Happy path
                {20,10,200},
                {-10,-20,200},
                {10,-5,-50},

                //Cero path
                {0,0,0},
                {0,50,0},
                {0,-50,0},


                //Edge cases
                {Long.MAX_VALUE,0,0},
                {Long.MIN_VALUE,0,0},
                {9223372036854775806L,1,9223372036854775806L}

        };
    }
    @Test(dataProvider = "multLongData",groups = "arithmetic")
    public void testSubLongData(long a, long b, long expected){
        long result = calculator.mult(a,b);
        Assert.assertEquals(result,expected,"The mult of "+a+" * "+b+" failed!");
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        calculator =null;
        System.out.println("Ended Testing for multiplication (Long)");

    }
}
