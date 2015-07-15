
package controller;

import entities.Brand;
import java.io.Serializable;
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
public class BrandController implements Serializable{

    @ManagedProperty(value="#{carsService}")
    private CarsService carsService;

    public CarsService getCarsService() {
        return carsService;
    }

    public void setCarsService(CarsService carsService) {
        this.carsService = carsService;
    }
    
    
    private String name;
    private String country;
    private List<Brand> listBrands;

    private Brand selectedBrand;
    private List<Brand> selectedBrands=new ArrayList<>();
    
    
   

    
    
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Brand getSelectedBrand() {
        return selectedBrand;
    }

    public void setSelectedBrand(Brand selectedBrand) {
        this.selectedBrand = selectedBrand;
    }

    public List<Brand> getSelectedBrands() {
        return selectedBrands;
    }

    public void setSelectedBrands(List<Brand> selectedBrands) {
        this.selectedBrands = selectedBrands;
    }

   
    public List<Brand> getListBrands() {
        return listBrands;
    }

    public void setListBrands(List<Brand> listBrands) {
        this.listBrands = listBrands;
    }
    
    
    @PostConstruct
    public void init(){
        
        listBrands=carsService.listBrand();
        
        
    }
    
    
    
    
    public BrandController() {
    }
    



public String save(){

Brand b=new Brand();
b.setCountry(country);
b.setName(name);

try{
    
    carsService.createBrand(b);
    
    
}catch(org.springframework.dao.DataIntegrityViolationException ex){
    createMessage("university exists", FacesMessage.SEVERITY_ERROR);
    name="";
    country="";
    return null;
}

listBrands.add(b);
name="";
country="";
    createMessage("brand saved", FacesMessage.SEVERITY_INFO);
return null;

}


public String deleteBrand(){
    
    
    if(selectedBrands.isEmpty())
        return null;
    
    for(Brand b:selectedBrands){
    
    
    try{
        
        carsService.deleteBrand(b);
        
        
    }catch(RuntimeException ex){
        
        createMessage("deleting error", FacesMessage.SEVERITY_ERROR);
        return null;
    }
    
    listBrands.remove(b);
    
    
    
}
    createMessage("brands deleted", FacesMessage.SEVERITY_INFO);
    
    return null;
}



public void createMessage(String text,FacesMessage.Severity severity){
    
    FacesMessage message=new FacesMessage(text);
    message.setSeverity(severity);
    FacesContext.getCurrentInstance().addMessage(null, message);
    
}









}