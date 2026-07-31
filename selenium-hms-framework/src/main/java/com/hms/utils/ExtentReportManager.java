package com.hms.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * Singleton wrapper around ExtentReports.
 * ExtentTest instances are ThreadLocal so parallel test execution doesn't
 * mix up log entries between threads.
 */
public class ExtentReportManager {

    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = ConfigReader.get("extent.report.path");
            if (reportPath == null) {
                reportPath = "test-output/ExtentReport.html";
            }
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("HMS Automation Report");
            spark.config().setReportName("HMS Site - Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Framework", "Selenium + TestNG + Cucumber");
            extent.setSystemInfo("Environment", ConfigReader.getBaseUrl());
        }
        return extent;
    }

    public static void createTest(String name) {
        ExtentTest test = getInstance().createTest(name);
        testThreadLocal.set(test);
    }

    public static ExtentTest getTest() {
        return testThreadLocal.get();
    }

    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}
