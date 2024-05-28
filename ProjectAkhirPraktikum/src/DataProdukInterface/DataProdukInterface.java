/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataProdukInterface;
import java.util.List;
import model.*;
/**
 *
 * @author jovan
 */
public interface DataProdukInterface {
    public void insert(DataProduk p);
    public void update(DataProduk p);
    public void delete(double PID);
    public List<DataProduk>getAll();
}
