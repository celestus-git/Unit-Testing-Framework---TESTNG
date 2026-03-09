package com.epam.tat.module4.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static ExtentReports extentReports = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result){
        ExtentTest extentTest = extentReports.createTest(result.getMethod().getMethodName());
    test.set(extentTest);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
       test.get().log(Status.PASS,"Test success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL,"Test failed"+result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extentReports!= null)  extentReports.flush();
        System.out.println("Report created and saved");
    }
}
