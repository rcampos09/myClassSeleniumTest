package com.selenium.config;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener extends BaseConfig implements ITestListener  {

  private static String getTestMethodName(ITestResult iTestResult) {
    return iTestResult.getMethod().getConstructorOrMethod().getName();
  }

  @Attachment(value = "Page screenshot", type = "image/png")
  public byte[] saveScreenshotPNG(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  @Attachment(value = "{0}", type = "text/plain")
  private static String saveTextLog(String message) {
    return message;
  }

  @Override
  public void onTestStart(ITestResult iTestResult) {
    System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
  }

  @Override
  public void onTestSuccess(ITestResult iTestResult) {
    System.out
        .println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");

    // Allure ScreenShotRobot and SaveTestLog
    Object testClass = iTestResult.getInstance();
    try {
      RemoteWebDriver driver = ((BaseConfig) testClass).getDriver();
      if (driver instanceof RemoteWebDriver) {
        System.out.println("Screenshot capture for test case : " + getTestMethodName(iTestResult));
        saveScreenshotPNG(driver);
      } else {
        System.out
            .println("Error Screenshot capture for test case : " + getTestMethodName(iTestResult));
      }
    } catch (Exception e) {
      System.out.println("Error saveScreenshotPNG Method");
      e.printStackTrace();
    }
    // Save a log on allure.
    saveTextLog(getTestMethodName(iTestResult) + "Screenshot taken!");
  }

  @Override
  public void onTestFailure(ITestResult iTestResult) {
    System.out
        .println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
    Object testClass = iTestResult.getInstance();

    // Allure ScreenShotRobot and SaveTestLog
    try {
      RemoteWebDriver driver = ((BaseConfig) testClass).getDriver();
      if (driver instanceof RemoteWebDriver) {
        System.out.println("Screenshot capture for test case : " + getTestMethodName(iTestResult));
        saveScreenshotPNG(driver);
      } else {
        System.out
            .println("Error Screenshot capture for test case : " + getTestMethodName(iTestResult));
      }
    } catch (Exception e) {
      System.out.println("Error saveScreenshotPNG Method");
      e.printStackTrace();
    }
    // Save a log on allure.
    saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
  }

  @Override
  public void onTestSkipped(ITestResult iTestResult) {
    System.out
        .println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    System.out.println(
        "Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
  }

  @Override
  public void onStart(ITestContext iTestContext) {
    System.out.println("I am in onStart method " + iTestContext.getName());
  }

  @Override
  public void onFinish(ITestContext iTestContext) {
    System.out.println("I am in onFinish method " + iTestContext.getName());
  }
}
