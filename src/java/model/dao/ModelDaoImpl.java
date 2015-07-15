
package model.dao;

import entities.Model;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("modelDao")
public class ModelDaoImpl implements ModelDao{
    
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public List<Model> listModel(){
        
        return getSession().createQuery("select m from Model m").list();
    }
    
    @Override
    public void createModel(Model m){
        
        getSession().save(m);
    }
    @Override
    public void deleteModel(Model m){
        
        getSession().delete(m);
    }
    
    @Override
     public List<Model> listByBrand(String brandName){
         
         return getSession().createQuery("select m from Model m where m.brand.name=:brandName").setParameter("brandName", brandName).list();
         
         
     }
    
}
