package com.selenium.test;

import org.testng.annotations.Test;
import com.selenium.config.BaseConfig;
import com.selenium.dataprovider.IntegratedDataProvider;
import com.selenium.page.CartPape;
import com.selenium.page.HomePage;
import com.selenium.page.PDPPage;

public class Test02 extends BaseConfig {

  @Test(dataProvider = "productSodimac", dataProviderClass = IntegratedDataProvider.class )
  public void example02() {
    HomePage homePage = new HomePage(driver);
    PDPPage pdpPage = homePage.searchProduct();
    pdpPage.clickAddToCart();
    CartPape cartPage = pdpPage.clickGoToCart();
    cartPage.validCartItem();
  }
}
