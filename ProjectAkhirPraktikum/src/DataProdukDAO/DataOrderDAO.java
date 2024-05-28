/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataProdukDAO;
import DataProdukInterface.DataOrderInterface;
import java.sql.*;
import java.util.*;
import Koneksi.connector;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author jovan
 */
public class DataOrderDAO implements DataOrderInterface {
    Connection connection;
   List<DataProduk> dp;
   List<DataOrder> dor;
    final String select = "SELECT * FROM orderdetails";
    final String insert = "INSERT INTO orderdetails (OrderID, ProductID,UnitPrice,Quantity,Discount) VALUES (?, ?, ?, ?, ?)";
    final String update = "UPDATE orderdetails set ProductID=?,UnitPrice=?,Quantity=?,Discount=?  WHERE OrderID=?;";
    final String delete = "delete from orderdetails WHERE OrderID=?";
    final String updateproduk = "UPDATE products set  UnitsOnOrder =? WHERE ProductID=?";
    final String updateprodukD = "UPDATE products set  UnitsInStock =?, UnitsOnOrder =? WHERE ProductID=?";
    final String cekOrderProduk = "SELECT * from products WHERE ProductID = ?";
    private double stokbaru,orderbaru,Orderlama,stoklama;

    public DataOrderDAO() {
        connection = connector.connection();
        
    }

    @Override
    public void insert(DataOrder o) {
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        PreparedStatement statement3 = null;
        try {
            
//            if (m.getAlur() < 0 || m.getAlur() > 5 || m.getAkting() < 0 || m.getAkting() > 5 || m.getPenokohan() < 0 || m.getPenokohan() > 5) {
//                throw new SQLException("Nilai-nilai harus berada di antara 0 dan 5");
//            }

            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement2 = connection.prepareStatement(updateproduk);
             statement3 = connection.prepareStatement(cekOrderProduk);
            statement3.setInt(1, (int)o.getProductID());
            ResultSet rs = statement3.executeQuery();
            
            while (rs.next()) {
                Orderlama = rs.getDouble("UnitsOnOrder");
            }
            //System.out.println(Orderlama);
            
            
            
            statement.setDouble(1, o.getOrderID());
            statement.setDouble(2, o.getProductID());
            statement.setDouble(3, o.getUnitPrice());
            statement.setDouble(4, o.getQuantity());
            statement.setDouble(5, o.getDiscount());
           // System.out.println(Orderlama);
            orderbaru = (Orderlama + o.getQuantity());
           // System.out.println(orderbaru);
            statement2.setDouble(1, orderbaru);
            statement2.setDouble(2, o.getProductID());
            statement.executeUpdate();
            statement2.executeUpdate();
           // ResultSet rs = statement.getGeneratedKeys();
            throw new SQLException("Data Order Berhasil Ditambahkan");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(DataOrder o) {
        PreparedStatement statement = null;
         PreparedStatement statement2 = null;
        PreparedStatement statement3 = null;
        //PreparedStatement statement2 = null;
        
        try {
//            if (m.getAlur() < 0 || m.getAlur() > 5 || m.getAkting() < 0 || m.getAkting() > 5 || m.getPenokohan() < 0 || m.getPenokohan() > 5) {
//                throw new SQLException("Nilai-nilai harus berada di antara 0 dan 5");
//            }
            statement = connection.prepareStatement(update);
            //statement2 = connection.prepareStatement(updateprodukD);
            statement.setDouble(5, o.getOrderID());
            statement.setDouble(1, o.getProductID());
            
            statement.setDouble(2, o.getUnitPrice());
            statement.setDouble(3, o.getQuantity());
            statement.setDouble(4, o.getDiscount());
            
           // orderbaru = (dp.get((int) o.getProductID()).getUnitsInStock() + o.getQuantity()-dor.get((int) o.getOrderID()).getQuantity());
            statement.executeUpdate();
            //statement2.executeUpdate();
            throw new SQLException("Data Order Berhasil Diupdate");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(DataOrder o) {
        
        
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        PreparedStatement statement3 = null;
        try {
            statement = connection.prepareStatement(delete);
            statement2 = connection.prepareStatement(updateprodukD);
            statement3 = connection.prepareStatement(cekOrderProduk);
            statement3.setInt(1, (int)o.getProductID());
            ResultSet rs = statement3.executeQuery();
            
            while (rs.next()) {
                Orderlama = rs.getDouble("UnitsOnOrder");
                stoklama = rs.getDouble("UnitsInStock");
            }
            //System.out.println(Orderlama);
            
            stokbaru =  (stoklama + o.getQuantity());
            orderbaru =  (Orderlama - o.getQuantity());
            statement.setDouble(1, o.getOrderID());
            
            statement2.setDouble(1,stokbaru);
            statement2.setDouble(2,orderbaru);
            statement2.setDouble(3,o.getProductID());
            statement.executeUpdate();
            statement2.executeUpdate();
            throw new SQLException("Data Order Berhasil Diselesaikan");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<DataOrder> getAll() {
        List<DataOrder> dm = null;
        try {
            dm = new ArrayList<DataOrder>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                DataOrder Order = new DataOrder();
                Order.setOrderID(rs.getDouble("OrderID"));
                Order.setProductID(rs.getDouble("ProductID"));
                Order.setUnitPrice(rs.getDouble("UnitPrice"));
                Order.setQuantity(rs.getDouble("Quantity"));
                Order.setDiscount(rs.getDouble("Discount"));
                dm.add(Order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dm;
    }
}
