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
public interface DataOrderInterface {
    public void insert(DataOrder o);
    public void update(DataOrder o);
    public void delete(DataOrder o);
    public List<DataOrder>getAll();
}
