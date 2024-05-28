/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataProdukDAO;
import DataProdukInterface.DataProdukInterface;
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
public class DataProdukDAO implements DataProdukInterface {
    Connection connection;
     final String select = "SELECT * FROM products";
    final String insert = "INSERT INTO products (ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit,UnitPrice,"
            + "UnitsInStock,UnitsOnOrder,ReorderLevel,Discontinued) VALUES (NULL, ?, ?, ?, ?, ?, ?,0,0,0)";
    final String update = "UPDATE products set ProductName=?, SupplierID=?, CategoryID=?, QuantityPerUnit=?,UnitPrice=?,"
            + "UnitsInStock=?  WHERE ProductID=?;";
    final String delete = "delete from products WHERE ProductID=?";

    public DataProdukDAO() {
        connection = connector.connection();
    }

    @Override
    public void insert(DataProduk m) {
        PreparedStatement statement = null;
        try {
            
//            if (m.getAlur() < 0 || m.getAlur() > 5 || m.getAkting() < 0 || m.getAkting() > 5 || m.getPenokohan() < 0 || m.getPenokohan() > 5) {
//                throw new SQLException("Nilai-nilai harus berada di antara 0 dan 5");
//            }
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, m.getProductName());
            statement.setDouble(2, m.getSupplierID());
            statement.setDouble(3, m.getCategoryID());
            statement.setString(4, m.getQuantityPerUnit());
            statement.setDouble(5, m.getUnitPrice());
            statement.setDouble(6, m.getUnitsInStock());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            throw new SQLException("Data Produk Berhasil Ditambahkan");
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
    public void update(DataProduk m) {
        PreparedStatement statement = null;
        try {
//            if (m.getAlur() < 0 || m.getAlur() > 5 || m.getAkting() < 0 || m.getAkting() > 5 || m.getPenokohan() < 0 || m.getPenokohan() > 5) {
//                throw new SQLException("Nilai-nilai harus berada di antara 0 dan 5");
//            }
            statement = connection.prepareStatement(update);
            statement.setString(1, m.getProductName());
            statement.setDouble(2, m.getSupplierID());
            statement.setDouble(3, m.getCategoryID());
            statement.setString(4, m.getQuantityPerUnit());
            statement.setDouble(5, m.getUnitPrice());
            statement.setDouble(6, m.getUnitsInStock());
            statement.setDouble(7, m.getProductID());
            statement.executeUpdate();
            throw new SQLException("Data Produk Berhasil Diupdate");
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
    public void delete(double ProductID) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);

            statement.setDouble(1, ProductID);
            statement.executeUpdate();
            throw new SQLException("Data Produk Berhasil Dihapus");
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
    public List<DataProduk> getAll() {
        List<DataProduk> dm = null;
        try {
            dm = new ArrayList<DataProduk>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                DataProduk produk = new DataProduk();
                produk.setProductID(rs.getDouble("ProductID"));
                produk.setProductName(rs.getString("ProductName"));
                produk.setSupplierID(rs.getDouble("SupplierID"));
                produk.setCategoryID(rs.getDouble("CategoryID"));
                produk.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
                produk.setUnitPrice(rs.getDouble("UnitPrice"));
                produk.setUnitsInStock(rs.getDouble("UnitsInStock"));
                produk.setUnitsOnOrder(rs.getDouble("UnitsOnOrder"));
                dm.add(produk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataProdukDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dm;
    }
}
