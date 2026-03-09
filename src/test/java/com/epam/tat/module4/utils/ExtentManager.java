package com.epam.tat.module4.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extentReports;

    public static ExtentReports createInstance(){

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/calculator-report.html");
        sparkReporter.config().setReportName("Calculator Testing report");
        sparkReporter.config().setDocumentTitle("QA Report - Module 4 Epam");

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);

        return extentReports;
    }
}
