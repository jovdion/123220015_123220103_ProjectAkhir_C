/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataProdukInterface;

import java.util.List;
import model.DataKaryawan;

/**
 *
 * @author Nathaleon
 */
public interface DataKaryawanInterface {
    public void insert(DataKaryawan k);
    public void update(DataKaryawan k);
    public void delete(double KID);
    public List<DataKaryawan>getAll();
}
