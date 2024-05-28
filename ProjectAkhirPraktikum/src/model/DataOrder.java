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
public class DataOrder {
    private double OrderID;
    private double ProductID;
    private double UnitPrice;
    private double Quantity;
    private double Discount;
    

   // private double nilai;
    
    public double getOrderID() {
        return OrderID;
    }

    public void setOrderID(double OrderID) {
        this.OrderID = OrderID;
    }
    
    public double getProductID() {
        return ProductID;
    }

    public void setProductID(double ProductID) {
        this.ProductID = ProductID;
    }
    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }
    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double Quantity) {
        this.Quantity = Quantity;
    }
    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double Discount) {
        this.Discount = Discount;
    }
    
    
}
