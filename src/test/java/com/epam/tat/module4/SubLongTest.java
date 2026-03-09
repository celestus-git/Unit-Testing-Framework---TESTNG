package com.epam.tat.module4;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SubLongTest {
    private Calculator calculator;
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Starting sub testing (Long)");

    }

    @DataProvider(name = "subLongData")
    public Object[][] getSubLongData(){
        return new Object[][]  {

                //Happy path
                {20,10,10},
                {-100,-200,100},
                {100,-50,150},

                //Cero path
                {0,0,0},
                {0,50,-50},

                //Edge cases
                {Long.MAX_VALUE,0,Long.MAX_VALUE},
                {Long.MIN_VALUE,0,Long.MIN_VALUE},
                {9223372036854775806L,1,9223372036854775805L}

        };
    }
   @Test(dataProvider = "subLongData",groups = "arithmetic")
   public void testSubLongData(long a, long b, long expected){
        long result = calculator.sub(a,b);
       Assert.assertEquals(result,expected,"The sub of "+a+" - "+b+" failed!");
   }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        calculator =null;
        System.out.println("Ended Testing for sub (Long)");

    }
}
