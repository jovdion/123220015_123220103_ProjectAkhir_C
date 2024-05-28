/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jovan
 */
public class DataProduk {
    private double ProductID;
    private String ProductName;
    private double SupplierID;
    private double CategoryID;
    private String QuantityPerUnit;
    private double UnitPrice;
    private double UnitsInStock;
    private double UnitsOnOrder;

   // private double nilai;
    
    public double getProductID() {
        return ProductID;
    }

    public void setProductID(double ProductID) {
        this.ProductID = ProductID;
    }
    
    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public double getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(double SupplierID) {
        this.SupplierID = SupplierID;
    }
    public double getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(double CategoryID) {
        this.CategoryID = CategoryID;
    }
    public String getQuantityPerUnit() {
        return QuantityPerUnit;
    }

    public void setQuantityPerUnit(String QuantityPerUnit) {
        this.QuantityPerUnit = QuantityPerUnit;
    }
    
    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }
    public double getUnitPrice() {
        return UnitPrice;
    }
    
    public void setUnitsInStock(double UnitsInStock) {
        this.UnitsInStock = UnitsInStock;
    }
    public double getUnitsInStock() {
        return UnitsInStock;
    }
     public void setUnitsOnOrder(double UnitsOnOrder) {
        this.UnitsOnOrder = UnitsOnOrder;
    }
    public double getUnitsOnOrder() {
        return UnitsOnOrder;
    }
    
}
