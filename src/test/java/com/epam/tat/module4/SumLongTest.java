package com.epam.tat.module4;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumLongTest {

    private Calculator calculator;

    @BeforeClass(alwaysRun = true)

    public void setUp() {
        calculator=new Calculator();
        System.out.println("Starting sum testing (Long)");
    }


@DataProvider(name = "sumLongData")
public Object[][] getSumLongData(){
        return new Object[][]{

                //Happy path
                {10,20,30},
                {-100,-200,-300},
                {100,-50,50},

                //Cero path
                {0,0,0},
                {0,50,50},

                //Edge cases
                {Long.MAX_VALUE,0,Long.MAX_VALUE},
                {Long.MIN_VALUE,0,Long.MIN_VALUE},
                {9223372036854775806L,1,9223372036854775807L}
        };
}

@Test(dataProvider = "sumLongData",groups = "arithmetic")
public void testSumLong(long a, long b, long expected){
        long result = calculator.sum(a,b);
    Assert.assertEquals(result,expected,"The sum of "+a+" + "+b+" failed!");
}


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        calculator=null;
        System.out.println("Ended Testing for sum (Long)");
    }
}
