package com.selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.selenium.config.BaseConfig;

public class HomePage extends BaseConfig {

  public HomePage(WebDriver driver) {
    super();
    this.driver = (RemoteWebDriver) driver;
    PageFactory.initElements(driver, this);
  }

  //create Element 

  @FindBy(xpath = "//*[@id=\"page-1399334048258\"]")
  private WebElement solucionesBtn;

  //create method

  public SolucionesPersonas clickSolucionesPersona() {
    solucionesBtn.click();
    return new SolucionesPersonas(driver);
  }
}
