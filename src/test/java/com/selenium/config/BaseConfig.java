package com.selenium.config;

import java.net.URI;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(com.selenium.config.Listener.class)

public class BaseConfig {

  public RemoteWebDriver driver;

  String urlPage = "https://www.bice.cl/";
  String urlSelenoid = "http://localhost";
  String portSelenoid = ":4444/wd/hub";

  @BeforeMethod()
  public RemoteWebDriver getDriver() throws Exception {
    if (driver == null) {

      DesiredCapabilities browser = new DesiredCapabilities();

      browser.setBrowserName("chrome");
      browser.setVersion("87.0");
      browser.setCapability("name", urlPage + " Test:" + getClass().getSimpleName());
      browser.setCapability("enableVNC", true);
      try {
        driver = new RemoteWebDriver(URI.create(urlSelenoid + portSelenoid).toURL(), browser);
        driver.manage().window().maximize();
        driver.get(urlPage);
      } catch (MalformedURLException e) {
        System.out.println("error " + e.getMessage());
        e.printStackTrace();
      }
    }
    return (RemoteWebDriver) driver;
  }

  @AfterMethod()
  public void teardownTest() {
    // Close browser and end the session
    driver.quit();
  }
}
