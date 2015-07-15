
package model.service;

import entities.Brand;
import entities.Model;
import java.util.List;
import model.dao.BrandDao;
import model.dao.ModelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("carsService")
@Transactional
public class CarServiceImpl implements CarsService{
    
    @Autowired
    private BrandDao brandDao;
    
    public BrandDao getBrandDao(){
        return brandDao;
    }
    @Autowired
    private ModelDao modelDao;

    public ModelDao getModelDao() {
        return modelDao;
    }

    public void setModelDao(ModelDao modelDao) {
        this.modelDao = modelDao;
    }
    
    
    
    
    @Override
    public List<Brand> listBrand(){
        
        return brandDao.listBrand();
    }
    
    @Override
    public void createBrand(Brand b){
    brandDao.createBrand(b);
        
    }
    
    @Override
    public void deleteBrand(Brand b){
        brandDao.deleteBrand(b);
    }
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Model> listModel(){
        
        return modelDao.listModel();
    }
    
    
    @Override
    public void createModel(Model m){
        
        modelDao.createModel(m);
    }
    
    @Override
    public void deleteModel(Model m){
        modelDao.deleteModel(m);
    }
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Model> listByBrand(String brandName){
        
        return modelDao.listByBrand(brandName);
    }
    
    
}
