package com.selenium.page;

import com.selenium.config.BaseConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimuladorHipotecario extends BaseConfig {

  public SimuladorHipotecario(WebDriver driver) {
    super();
    this.driver = (RemoteWebDriver) driver;
    PageFactory.initElements(driver, this);
  }

  //create Element 

  @FindBy(xpath = "(//*[contains(text(),'Comprar e Invertir en Propiedades')])[2]")
  private WebElement comprarInvertirPropiedades;

  @FindBy(xpath = "//*[contains(@class, 'form-control tamañoLetraCaja1 ng-valid ng-touched ng-dirty')]")
  private WebElement valorPropiedad;

  //create method

  public ComprarInvertirPropiedades comprarInvertirPropiedades() {
    comprarInvertirPropiedades.click();
    return new ComprarInvertirPropiedades(driver);
  }
}
