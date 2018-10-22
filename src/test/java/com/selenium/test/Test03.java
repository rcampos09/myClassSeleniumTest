package com.selenium.test;

import org.testng.annotations.Test;
import com.selenium.config.BaseConfig;
import com.selenium.page.HomePage;
import com.selenium.page.PDPPage;

public class Test03 extends BaseConfig {

  @Test
  public void example03() {
    HomePage homePage = new HomePage(driver);
    PDPPage pdpPage = homePage.searchProduct();
    pdpPage.clickAddToCart();
  }
}
 