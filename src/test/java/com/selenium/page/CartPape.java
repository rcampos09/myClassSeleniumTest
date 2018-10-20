package com.selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.selenium.config.BaseConfig;

public class CartPape extends BaseConfig {

  public CartPape(WebDriver driver) {
    super();
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }
 
  // create Element
  @FindBy(xpath = "//*[@class='CartItem-con']")
  private WebElement cartItemDiv;
 
  //create method
  public void validCartItem() {
    cartItemDiv.isDisplayed();
  }
  
  //create method
  public void invalidCartItem() {
    cartItemDiv.isEnabled();
  }
}
