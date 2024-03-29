package entities;
// Generated 14-jul-2015 18:23:22 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Model generated by hbm2java
 */
@Entity
@Table(name="model"
    ,catalog="test"
)
public class Model  implements java.io.Serializable {


     private String name;
     private Brand brand;
     private Integer year;
     private String fuel;
     private Integer speed;

    public Model() {
    }

	
    public Model(String name, Brand brand) {
        this.name = name;
        this.brand = brand;
    }
    public Model(String name, Brand brand, Integer year, String fuel, Integer speed) {
       this.name = name;
       this.brand = brand;
       this.year = year;
       this.fuel = fuel;
       this.speed = speed;
    }
   
     @Id 

    
    @Column(name="name", unique=true, nullable=false, length=100)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="brand", nullable=false)
    public Brand getBrand() {
        return this.brand;
    }
    
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    
    @Column(name="year")
    public Integer getYear() {
        return this.year;
    }
    
    public void setYear(Integer year) {
        this.year = year;
    }

    
    @Column(name="fuel", length=45)
    public String getFuel() {
        return this.fuel;
    }
    
    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    
    @Column(name="speed")
    public Integer getSpeed() {
        return this.speed;
    }
    
    public void setSpeed(Integer speed) {
        this.speed = speed;
    }




}


