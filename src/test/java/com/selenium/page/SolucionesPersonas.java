package com.selenium.page;

import com.selenium.config.BaseConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SolucionesPersonas extends BaseConfig {

  public SolucionesPersonas(WebDriver driver) {
    super();
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  //create Element 

  @FindBy(xpath = "(//*[contains(text(),'Comprar e Invertir en Propiedades')])[2]")
  private WebElement comprarInvertirPropiedades;
  //create method

  public ComprarInvertirPropiedades clickSolucionesPersona() {
    comprarInvertirPropiedades.click();
    return new ComprarInvertirPropiedades(driver);
  }
}
