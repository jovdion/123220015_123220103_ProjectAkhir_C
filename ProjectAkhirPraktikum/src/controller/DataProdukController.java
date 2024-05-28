/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DataProdukDAO.DataProdukDAO;
import DataProdukInterface.DataProdukInterface;
import javax.swing.JOptionPane;
import model.*;
import View.MainView;
/**
 *
 * @author Nathaleon
 */
public class DataProdukController {
    MainView frame;
    DataProdukInterface ImplDataProduk;
    List<DataProduk> dm;

    public DataProdukController(MainView frame) {
        this.frame = frame;
        ImplDataProduk = new DataProdukDAO();
        dm = ImplDataProduk.getAll();
    }

    public void isiTabel() {
        dm = ImplDataProduk.getAll();
        ModelTabelDataProduk mm = new ModelTabelDataProduk(dm);
        frame.gettbl_data().setModel(mm);
    }

    public void insert() {
        DataProduk dm = new DataProduk();
        dm.setProductName(frame.gett_ProductName().getText());
        dm.setSupplierID(Double.parseDouble(frame.gett_SupplierID().getText()));
        dm.setCategoryID(Double.parseDouble(frame.gett_CategoryID().getText()));
        dm.setQuantityPerUnit(frame.gett_QuantityPerUnit().getText());
        dm.setUnitPrice(Double.parseDouble(frame.gett_UnitPrice().getText()));
        dm.setUnitsInStock(Double.parseDouble(frame.gett_UnitsInStock().getText()));
        
        ImplDataProduk.insert(dm);
    }

    public void update() {
        DataProduk dm = new DataProduk();
        dm.setProductID(Double.parseDouble((frame.gett_ProductID().getText())));
        dm.setProductName(frame.gett_ProductName().getText());
        dm.setSupplierID(Double.parseDouble(frame.gett_SupplierID().getText()));
        dm.setCategoryID(Double.parseDouble(frame.gett_CategoryID().getText()));
        dm.setQuantityPerUnit(frame.gett_QuantityPerUnit().getText());
        dm.setUnitPrice(Double.parseDouble(frame.gett_UnitPrice().getText()));
        dm.setUnitsInStock(Double.parseDouble(frame.gett_UnitsInStock().getText()));
        ImplDataProduk.update(dm);
    }

    public void delete() {
        Double ProductID = (Double.parseDouble(frame.gett_ProductID().getText()));
        ImplDataProduk.delete(ProductID);
    }
}
