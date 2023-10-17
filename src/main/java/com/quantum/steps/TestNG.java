package com.quantum.steps;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class TestNG implements ITestListener {

    public void Logout() throws Throwable {
        System.out.println("I am in TestNG after Test");
        ParabankStepsDefs.the_user_is_in_the_customer_page();
        ParabankStepsDefs.the_user_clicks_on_the_Logout_button();
        ParabankStepsDefs.the_user_is_logged_out_successfully();
    }


    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        try {
            Logout();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            Logout();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
