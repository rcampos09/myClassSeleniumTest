package com.selenium.dataprovider;

import org.testng.annotations.DataProvider;
import com.selenium.dataprovider.FileDataProvider;
import com.google.gson.Gson;
import com.selenium.entities.Producto;

public class IntegratedDataProvider {
  
  @DataProvider
  public static Object[][] productSodimac() {
    Gson gson = new Gson();
    Producto product =
        gson.fromJson(
            FileDataProvider.asString(
                String.format("./resource/product.json")),
            Producto.class);
    return new Object[][] {{product}};
  }
  
  @DataProvider
  public static Object[][] productHDnormal() {
    Gson gson = new Gson();
    Producto product =
        gson.fromJson(
            FileDataProvider.asString(
                String.format("./resource/productHDnormal.json")),
            Producto.class);
    return new Object[][] {{product}};
  }
  
  @DataProvider
  public static Object[][] productHDProgrammed() {
    Gson gson = new Gson();
    Producto product =
        gson.fromJson(
            FileDataProvider.asString(
                String.format("./resource/productHDProgrammed.json")),
            Producto.class);
    return new Object[][] {{product}};
  }
  
}
