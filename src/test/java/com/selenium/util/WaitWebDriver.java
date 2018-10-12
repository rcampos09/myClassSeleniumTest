package com.selenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitWebDriver {

  public WaitWebDriver() {
    super();
  }

  public static void waitVisibility(WebDriver driver, WebElement element, int time) {
    WebDriverWait wait = new WebDriverWait(driver, time);
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public static void waitClickable(WebDriver driver, WebElement element, int time) {
    WebDriverWait wait = new WebDriverWait(driver, time);
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  public static void waitSelected(WebDriver driver, WebElement element, int time) {
    WebDriverWait wait = new WebDriverWait(driver, time);
    wait.until(ExpectedConditions.elementToBeSelected(element));
  }

  public static void waitAlert(WebDriver driver, int time) {
    WebDriverWait wait = new WebDriverWait(driver, time);
    wait.until(ExpectedConditions.alertIsPresent());
  }

  public static void waitInvisibility(WebDriver driver, WebElement element, int time) {
    WebDriverWait wait = new WebDriverWait(driver, time);
    wait.until(ExpectedConditions.invisibilityOf(element));
  }

}
