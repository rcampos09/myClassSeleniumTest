package com.selenium.entities;

public class Producto {
    private String sku;
    private String nombre_producto;
    
    public Producto(String sku, String nombre_producto) {
      super();
      this.sku = sku;
      this.nombre_producto = nombre_producto;
    }

    public String getSku() {
      return sku;
    }

    public void setSku(String sku) {
      this.sku = sku;
    }

    public String getNombre_producto() {
      return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
      this.nombre_producto = nombre_producto;
    }
    
}
