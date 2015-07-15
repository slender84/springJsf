
package model.service;

import entities.Brand;
import entities.Model;
import java.util.List;


public interface CarsService {
    
    public void createBrand(Brand b);
    public void deleteBrand(Brand b);
    public List<Brand> listBrand();
    
    public List<Model> listModel();
    public void createModel(Model m);
    public void deleteModel(Model m);
    
    public List<Model> listByBrand(String brandName);
    
}
