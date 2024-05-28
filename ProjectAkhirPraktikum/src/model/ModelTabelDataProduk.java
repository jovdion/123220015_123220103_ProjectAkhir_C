/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author jovan
 */
public class ModelTabelDataProduk extends AbstractTableModel {
    List<DataProduk> dm;
    public ModelTabelDataProduk(List<DataProduk>dm){
        this.dm = dm;
    }

    @Override
    public int getRowCount() {
        return dm.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }
    
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2:
                return "ID Supplier";
            case 3:
                return "ID Kategori";
            case 4:
                return "Quantity Per Unit";
            case 5:
                return "Harga";
            case 6:
                return "Stok";
            case 7:
                return "Unit Sedang Diorder";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0:
                return dm.get(row).getProductID();
            case 1:
                return dm.get(row).getProductName();
            case 2:
                return dm.get(row).getSupplierID();
            case 3:
                return dm.get(row).getCategoryID();
            case 4:
                return dm.get(row).getQuantityPerUnit();
             case 5:
                return dm.get(row).getUnitPrice();
            case 6:
                return dm.get(row).getUnitsInStock();
            case 7:
                return dm.get(row).getUnitsOnOrder();
            default:
                return null;
        }
    }
}
