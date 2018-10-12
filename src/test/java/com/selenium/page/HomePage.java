package com.selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.selenium.config.BaseConfig;

public class HomePage extends BaseConfig {

  public HomePage(WebDriver driver) {
    super();
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  //create Element 
  
  @FindBy(id = "searchBoxInput")
  private WebElement searchBoxInpt; 
  
  @FindBy(xpath = "//div[@class='searchIcon_-xI-Ide9']")
  private WebElement searchIconBtn; 
  
  //create method
  
  public PDPPage searchSKU() {
    searchBoxInpt.sendKeys("345678");
    searchIconBtn.click();
    return new PDPPage(driver);
  }
  
  public PDPPage searchProduct() {
    searchBoxInpt.sendKeys("654654");
    searchIconBtn.click();
    return new PDPPage(driver);
  }
}
