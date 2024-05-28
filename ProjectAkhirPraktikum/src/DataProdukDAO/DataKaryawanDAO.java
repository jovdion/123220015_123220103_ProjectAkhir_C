/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataProdukDAO;

/**
 *
 * @author Nathaleon
 */

import DataProdukInterface.DataKaryawanInterface;
import Koneksi.connector;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.*;

public class DataKaryawanDAO implements DataKaryawanInterface {
    Connection connection;
    final String select = "SELECT EmployeeID, LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension FROM employees";
    final String insert = "INSERT INTO employees (EmployeeID, LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension, Photo, Notes, ReportsTo) "
                        + "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NULL, NULL)";
    final String update = "UPDATE employees SET LastName=?, FirstName=?, Title=?, TitleOfCourtesy=?, BirthDate=?, HireDate=?, Address=?, City=?, Region=?, PostalCode=?, Country=?, HomePhone=?, Extension=? WHERE EmployeeID=?";
    final String delete = "DELETE FROM employees WHERE EmployeeID=?";

    public DataKaryawanDAO() {
        connection = connector.connection();
    }

    @Override
    public void insert(DataKaryawan k) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, k.getLastName());
            statement.setString(2, k.getFirstName());
            statement.setString(3, k.getTitle());
            statement.setString(4, k.getTitleOfCourtesy());
            statement.setDate(5, new java.sql.Date(k.getBirthDate().getTime()));
            statement.setDate(6, new java.sql.Date(k.getHireDate().getTime()));
            statement.setString(7, k.getAddress());
            statement.setString(8, k.getCity());
            statement.setString(9, k.getRegion());
            statement.setString(10, k.getPostalCode());
            statement.setString(11, k.getCountry());
            statement.setString(12, k.getHomePhone());
            statement.setString(13, k.getExtension());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            throw new SQLException("Data Karyawan Berhasil Ditambahkan");
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
    public void update(DataKaryawan k) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, k.getLastName());
            statement.setString(2, k.getFirstName());
            statement.setString(3, k.getTitle());
            statement.setString(4, k.getTitleOfCourtesy());
            statement.setDate(5, new java.sql.Date(k.getBirthDate().getTime()));
            statement.setDate(6, new java.sql.Date(k.getHireDate().getTime()));
            statement.setString(7, k.getAddress());
            statement.setString(8, k.getCity());
            statement.setString(9, k.getRegion());
            statement.setString(10, k.getPostalCode());
            statement.setString(11, k.getCountry());
            statement.setString(12, k.getHomePhone());
            statement.setString(13, k.getExtension());
            statement.setInt(14, k.getEmployeeID());
            statement.executeUpdate();
            throw new SQLException("Data Karyawan Berhasil Diupdate");
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
    public void delete(double EmployeeID) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setDouble(1, EmployeeID);
            statement.executeUpdate();
            throw new SQLException("Data Karyawan Berhasil Dihapus");
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
    public List<DataKaryawan> getAll() {
        List<DataKaryawan> dk = null;
        try {
            dk = new ArrayList<DataKaryawan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                DataKaryawan karyawan = new DataKaryawan();
                karyawan.setEmployeeID(rs.getInt("EmployeeID"));
                karyawan.setLastName(rs.getString("LastName"));
                karyawan.setFirstName(rs.getString("FirstName"));
                karyawan.setTitle(rs.getString("Title"));
                karyawan.setTitleOfCourtesy(rs.getString("TitleOfCourtesy"));
                karyawan.setBirthDate(rs.getDate("BirthDate"));
                karyawan.setHireDate(rs.getDate("HireDate"));
                karyawan.setAddress(rs.getString("Address"));
                karyawan.setCity(rs.getString("City"));
                karyawan.setRegion(rs.getString("Region"));
                karyawan.setPostalCode(rs.getString("PostalCode"));
                karyawan.setCountry(rs.getString("Country"));
                karyawan.setHomePhone(rs.getString("HomePhone"));
                karyawan.setExtension(rs.getString("Extension"));
                dk.add(karyawan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataKaryawanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dk;
    }

}

