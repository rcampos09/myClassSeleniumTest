package com.selenium.test;

import org.testng.annotations.Test;
import com.selenium.config.BaseConfig;
import com.selenium.page.CartPape;
import com.selenium.page.HomePage;
import com.selenium.page.PDPPage;

public class Test01 extends BaseConfig {

  @Test()
  public void exampleTest() {
    // create instance HomePage
    HomePage homePage = new HomePage(driver);
    // search sku method in page (HomePage)
    PDPPage pdpPage = homePage.searchSKU();
    // Add sku to cart
    pdpPage.clickAddToCart();
    // To Go CartPage
    CartPape cartPage = pdpPage.clickGoToCart();
    // Valid Product add in cart
    cartPage.validCartItem();
  }
}
