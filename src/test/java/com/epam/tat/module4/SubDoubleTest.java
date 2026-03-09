package com.epam.tat.module4;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubDoubleTest {
    private Calculator calculator;
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Starting sub testing (Double)");

    }
    @DataProvider(name = "subDoubleData")
    public Object[][] getSubDoubleData(){
        return new Object[][]{
                //Happy path
                {20.1,10.0,10.1},
                {-200.1,-100.1,-100.0},
                {-100.9,50.1,-150.6},

                //Cero path
                {Double.MIN_VALUE,0.0,Double.MIN_VALUE},
                {0.0,-0.0,0.0},

                //Edge cases
                {Double.MAX_VALUE,Double.MAX_VALUE,0.0},
                {-Double.MAX_VALUE,-Double.MAX_VALUE,0.0},
                {Double.POSITIVE_INFINITY,100.0,Double.POSITIVE_INFINITY}
        };
    }
@Test(dataProvider = "subDoubleData",groups = "arithmetic")
public void testSubDouble(double a,double b, double expected){
        double result = calculator.sub(a,b);
    Assert.assertEquals(result,expected,0.000001,"The sub of "+a+" - "+b+" failed!");

}
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        calculator =null;
        System.out.println("Ended Testing for sub (Double)");

    }
}
