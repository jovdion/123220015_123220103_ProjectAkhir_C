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
public class ModelTabelDataOrder extends AbstractTableModel {
    List<DataOrder> dm;
    public ModelTabelDataOrder(List<DataOrder>dm){
        this.dm = dm;
    }

    @Override
    public int getRowCount() {
        return dm.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "ID";
            case 1:
                return "ProductID";
            case 2:
                return "UnitPrice";
            case 3:
                return "Quantity";
            case 4:
                return "Discount";
            
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0:
                return dm.get(row).getOrderID();
            case 1:
                return dm.get(row).getProductID();
            case 2:
                return dm.get(row).getUnitPrice();
            case 3:
                return dm.get(row).getQuantity();
            case 4:
                return dm.get(row).getDiscount();
             
            default:
                return null;
        }
    }
}
