/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import entities.Brand;
import entities.Model;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("brandDao")
public class BrandDaoImpl implements BrandDao{

    private SessionFactory sessionFactory;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    
    public Session getSession(){
        
        return sessionFactory.getCurrentSession();
    }
    
    
    @Override
    public List<Brand> listBrand(){
        
        return getSession().createQuery("select b from Brand b").list();
    }
    
    @Override
    public void createBrand(Brand b){
        getSession().save(b);
    }
    
    @Override
    public void deleteBrand(Brand b){
        
        getSession().delete(b);
    }
    
    @Override
     public List<Model> listByBrand(String brandName){
         
         return getSession().createQuery("select m from Model m where m.brand=:brandName").setParameter("brandName", brandName).list();
         
     }
    
    
    
}
