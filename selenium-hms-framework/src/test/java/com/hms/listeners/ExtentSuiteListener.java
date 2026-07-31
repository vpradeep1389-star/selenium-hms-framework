package com.hms.listeners;

import com.hms.utils.ExtentReportManager;
import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * Registered in testng.xml. Ensures the Extent HTML report is written to
 * disk once, after the entire suite (all Cucumber scenarios) has finished.
 */
public class ExtentSuiteListener implements ISuiteListener {

    @Override
    public void onFinish(ISuite suite) {
        ExtentReportManager.flush();
    }
}
