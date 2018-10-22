package com.selenium.test;

import org.testng.annotations.Test;
import com.selenium.config.BaseConfig;
import com.selenium.dataprovider.IntegratedDataProvider;
import com.selenium.entities.Producto;
import com.selenium.page.CartPape;
import com.selenium.page.HomePage;
import com.selenium.page.PDPPage;

public class Test01 extends BaseConfig {

  @Test(dataProvider = "productSodimac", dataProviderClass = IntegratedDataProvider.class )
  public void example01(Producto product) {
    // create instance HomePage
    HomePage homePage = new HomePage(driver);
    // search sku method in page (HomePage)
    PDPPage pdpPage = homePage.searchSKU(product.getSku());
    // Add sku to cart
    pdpPage.clickAddToCart();
    // To Go CartPage
    CartPape cartPage = pdpPage.clickGoToCart();
    // Valid Product add in cart
    cartPage.validCartItem();
  }
} 
 