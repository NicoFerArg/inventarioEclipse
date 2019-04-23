package com.inventario.controller;

import com.inventario.entities.Marca;
import com.inventario.entities.Repuesto;
import com.inventario.model.service.AutosService;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name="repuesto")
@ViewScoped
public class RepuestoController implements Serializable {
    
    public static final long serialVersionUID = 1L;

    private List<Repuesto> listPart = new ArrayList<>();
    private List<Marca> listBrand = new ArrayList<>();
    private String name;
    private int stock;
    private int stockmin;
    private int stockmax;
    private Date createdat;
    
    private int id_brand;
    
    private boolean checkBrand;
    
    
    @ManagedProperty(value="#{autosService}")
    private AutosService carsService;

    public AutosService getCarsService() {
        return carsService;
    }

    public void setCarsService(AutosService carsService) {
        this.carsService = carsService;
    }

    public int getId_brand() {
        return id_brand;
    }

    public void setId_brand(int id_brand) {
        this.id_brand = id_brand;
    }

  

    public boolean isCheckBrand() {
        return checkBrand;
    }

    public void setCheckBrand(boolean checkBrand) {
        this.checkBrand = checkBrand;
    }
    
    public List<Repuesto> getListPart() {
        return listPart;
    }

    public void setListPart(List<Repuesto> listPart) {
        this.listPart = listPart;
    }

    public List<Marca> getListBrand() {
        return listBrand;
    }

    public void setListBrand(List<Marca> listBrand) {
        this.listBrand = listBrand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockmin() {
        return stockmin;
    }

    public void setStockmin(int stockmin) {
        this.stockmin = stockmin;
    }

    public int getStockmax() {
        return stockmax;
    }

    public void setStockmax(int stockmax) {
        this.stockmax = stockmax;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }
    
    @PostConstruct
    public void init(){
    
        listBrand = carsService.listBrand();
     //   listPart = carsService.listPart();
    }
    
    public void changeBrand(){
    
        checkBrand = true;
        listPart = carsService.listByBrand(id_brand);
    }
    
   public String save(){
    
       Marca b = new Marca(id_brand);
       Repuesto p= new Repuesto();
        
        p.setNombre(name);
        p.setMarca(b);
        p.setStock(stock);
        p.setStockMin(stockmin);
        p.setStockMax(stockmax);
        
        
        try{
            
            carsService.createPart(p);
            
        
        }catch(org.hibernate.PropertyValueException e){
            Message("Part already exists",FacesMessage.SEVERITY_ERROR);
            return null; 
        }
         listPart.add(p);
         
         Message("Part saved",FacesMessage.SEVERITY_INFO);
         
         name = null;
         return null;
  
    }
    
    
    public void Message(String text , FacesMessage.Severity severety){
  
      FacesMessage message = new FacesMessage(text);
      message.setSeverity(severety);
      FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    
    public RepuestoController() {
    }
    
}
