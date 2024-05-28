/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DataProdukDAO.DataOrderDAO;
import DataProdukInterface.DataOrderInterface;
import javax.swing.JOptionPane;
import model.*;
import View.MainView;
/**
 *
 * @author jovan
 */
public class DataOrderController {
    MainView frame;
    DataOrderInterface ImplDataOrder;
    List<DataOrder> dm;

    public DataOrderController(MainView frame) {
        this.frame = frame;
        ImplDataOrder = new DataOrderDAO();
        dm = ImplDataOrder.getAll();
    }

    public void isiTabel() {
        dm = ImplDataOrder.getAll();
        ModelTabelDataOrder mm = new ModelTabelDataOrder(dm);
        frame.gettbl_Order().setModel(mm);
    }

    public void insert() {
        DataOrder dm = new DataOrder();
        
        dm.setOrderID(Double.parseDouble(frame.getO_OrderID().getText()));
        dm.setProductID(Double.parseDouble(frame.getO_ProductID().getText()));
        dm.setDiscount(Double.parseDouble(frame.getO_Discount().getText()));
        dm.setUnitPrice(Double.parseDouble(frame.getO_UnitPrice().getText()));
        dm.setQuantity(Double.parseDouble(frame.getO_Quantity().getText()));
        
        ImplDataOrder.insert(dm);
    }

    public void update() {
//        DataOrder dm = new DataOrder();
//        dm.setProductID(Double.parseDouble((frame.gett_ProductID().getText())));
//        dm.setProductName(frame.gett_ProductName().getText());
//        dm.setSupplierID(Double.parseDouble(frame.gett_SupplierID().getText()));
//        dm.setCategoryID(Double.parseDouble(frame.gett_CategoryID().getText()));
//        dm.setQuantityPerUnit(frame.gett_QuantityPerUnit().getText());
//        dm.setUnitPrice(Double.parseDouble(frame.gett_UnitPrice().getText()));
//        dm.setUnitsInStock(Double.parseDouble(frame.gett_UnitsInStock().getText()));
//        ImplDataOrder.update(dm);
    }

    public void delete() {
        DataOrder dm = new DataOrder();
        
        dm.setOrderID(Double.parseDouble(frame.getO_OrderID().getText()));
        dm.setProductID(Double.parseDouble(frame.getO_ProductID().getText()));
        dm.setDiscount(Double.parseDouble(frame.getO_Discount().getText()));
        dm.setUnitPrice(Double.parseDouble(frame.getO_UnitPrice().getText()));
        dm.setQuantity(Double.parseDouble(frame.getO_Quantity().getText()));
        ImplDataOrder.delete(dm);
    }
}
