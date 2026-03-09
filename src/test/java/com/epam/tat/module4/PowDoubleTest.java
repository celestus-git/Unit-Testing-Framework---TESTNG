package com.epam.tat.module4;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PowDoubleTest {
    private Calculator calculator;

    @BeforeClass(alwaysRun = true)
    public void SetUp(){
        calculator = new Calculator();
        System.out.println("Starting testing for pow Double");
    }


    @DataProvider(name = "powDoubleData")
    public Object[][] getPowDoubleData(){
        return new Object[][]{

                //Happy path

                {20.1,1.0,20.1},
                {10.0,-1.0,0.1},
                {-2.0,5.0,-32.0},
                {2.0,-5.0,0.03125},

                //Cero path
                {Double.MIN_VALUE,0.0,1.0},
                {Double.MAX_VALUE,0.0,1.0},
                {0.0, 0.0, 1.0},

                //Edge cases
                {-4.0,0.5,Double.NaN},
                {2.0,2000.0,Double.POSITIVE_INFINITY},
                {0.0,-1.0,Double.POSITIVE_INFINITY}

        };
    }

@Test(dataProvider = "powDoubleData",groups = "arithmetic")
public void getPowDouble(double a, double b, double expected){
        double result = calculator.pow(a,b);
    Assert.assertEquals(result,expected,"The power of "+a+" ^ "+b+" failed!");
}


    @AfterClass(alwaysRun = true)
    public void tearDown(){
        calculator=null;
        System.out.println("Testing for pow Double finished");
    }


}
