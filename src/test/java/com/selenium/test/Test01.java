package com.selenium.test;

import com.selenium.page.ComprarInvertirPropiedades;
import com.selenium.page.SimuladorHipotecario;
import com.selenium.page.SolucionesPersonas;
import org.testng.annotations.Test;
import com.selenium.config.BaseConfig;
import com.selenium.dataprovider.IntegratedDataProvider;
import com.selenium.entities.Producto;
import com.selenium.page.HomePage;

public class Test01 extends BaseConfig {

  @Test(dataProvider = "productSodimac", dataProviderClass = IntegratedDataProvider.class )
  public void example01(Producto product) {

    HomePage homePage = new HomePage(driver);

    SolucionesPersonas solucionesPersonas = homePage.clickSolucionesPersona();

    ComprarInvertirPropiedades comprarInvertirPropiedades = solucionesPersonas.clickSolucionesPersona();

    SimuladorHipotecario simuladorHipotecario = comprarInvertirPropiedades.clickSimuladorHipotecario();

  }
} 
 