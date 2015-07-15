
package model.dao;

import entities.Brand;
import entities.Model;
import java.util.List;


public interface BrandDao {
    
    public List<Brand> listBrand();
    public void createBrand(Brand b);
    public void deleteBrand(Brand b);
    
    public List<Model> listByBrand(String brandName);
    
    
}
