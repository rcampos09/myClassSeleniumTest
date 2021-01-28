package com.selenium.page;

import com.selenium.config.BaseConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComprarInvertirPropiedades extends BaseConfig {

  public  ComprarInvertirPropiedades(WebDriver driver) {
    super();
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  //create Element 

  @FindBy(xpath = "//*[@id=\"1399334045639\"]/div[4]")
  private WebElement simuladorHipotecario;

  //create method

  public SimuladorHipotecario clickSimuladorHipotecario() {
    simuladorHipotecario.click();
    return new SimuladorHipotecario(driver);
  }
}
