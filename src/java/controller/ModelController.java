/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Brand;
import entities.Model;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.service.CarsService;


@ManagedBean
@ViewScoped
public class ModelController {

    
    @ManagedProperty(value="#{carsService}")
    private CarsService carsService;

    public CarsService getCarsService() {
        return carsService;
    }

    public void setCarsService(CarsService carsService) {
        this.carsService = carsService;
    }
    
    
    private List<Model> listModels=new ArrayList<>();
    private List<Brand>listBrands=new ArrayList<>();
    private String modelName;
    private String modelFuel;
    private Integer modelYear;
    
    private Model selectedModel;
    
    
    private String brandString;
    private boolean checkBrand;

    public Model getSelectedModel() {
        return selectedModel;
    }

    public void setSelectedModel(Model selectedModel) {
        this.selectedModel = selectedModel;
    }

    
    
    
    
    public String getBrandString() {
        return brandString;
    }

    public void setBrandString(String brandString) {
        this.brandString = brandString;
    }

    public boolean isCheckBrand() {
        return checkBrand;
    }

    public void setCheckBrand(boolean checkBrand) {
        this.checkBrand = checkBrand;
    }
    
    
    
    

    public List<Model> getListModels() {
        return listModels;
    }

    public void setListModels(List<Model> listModels) {
        this.listModels = listModels;
    }

    public List<Brand> getListBrands() {
        return listBrands;
    }

    public void setListBrands(List<Brand> listBrands) {
        this.listBrands = listBrands;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelFuel() {
        return modelFuel;
    }

    public void setModelFuel(String modelFuel) {
        this.modelFuel = modelFuel;
    }

    public Integer getModelYear() {
        return modelYear;
    }

    public void setModelYear(Integer modelYear) {
        this.modelYear = modelYear;
    }
    
    
    
    
    
    
    
    
    
    
    
    public ModelController() {
    }
    
    @PostConstruct
    public void init(){
        
        
        listBrands=carsService.listBrand();
        
        
    }
    
    
    public void changeBrand(){
        
        checkBrand=true;
        listModels=carsService.listByBrand(brandString);
        
        
        
    }
    
    public String createModel(){
        
        Brand b=new Brand(brandString);
        Model m=new Model();
        m.setBrand(b);
        m.setFuel(modelFuel);
        m.setName(modelName);
        m.setYear(modelYear);
        
        try{
            
            carsService.createModel(m);
            
            
            
        }catch(org.springframework.dao.DataIntegrityViolationException ex){
            
            createMessage("model already exists", FacesMessage.SEVERITY_ERROR);
            return null;
            
        }
        
        listModels.add(m);
        createMessage("model saved", FacesMessage.SEVERITY_INFO);
        brandString="";
        modelFuel="";
        modelYear=null;
        modelName="";
                
        return null;
        
        
    }
    
    
    public String deleteModel(){
        
        
        try{
            
            carsService.deleteModel(selectedModel);
            
            
        }catch(RuntimeException ex){
            createMessage("error deleting", FacesMessage.SEVERITY_ERROR);
            return null;
            
        }
        
        listModels.remove(selectedModel);
        createMessage("model deleted", FacesMessage.SEVERITY_INFO);
        return null;
    }
    
    
    
    
    public void createMessage(String text,FacesMessage.Severity severity){
    
    FacesMessage message=new FacesMessage(text);
    message.setSeverity(severity);
    FacesContext.getCurrentInstance().addMessage(null, message);
    
}
    
}
