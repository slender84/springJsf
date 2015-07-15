
package model.dao;

import entities.Model;
import java.util.List;


public interface ModelDao {
    
    public List<Model> listModel();
    public void createModel(Model m);
    public void deleteModel(Model m);
    public List<Model> listByBrand(String brandName);
    
    
}
