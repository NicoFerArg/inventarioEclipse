package com.inventario.controller;

import com.inventario.entities.Marca;
import com.inventario.model.service.AutosService;
import java.io.Serializable;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name="marcas")
@ViewScoped
public class MarcaController implements Serializable {

   public static final long serialVersionUID = 1L;
    
    @ManagedProperty(value="#{carsService}")
    private AutosService carsService;

    public AutosService getCarsService() {
        return carsService;
    }

    public void setCarsService(AutosService carsService) {
        this.carsService = carsService;
    }

   
    
    private int id;
    private String name;
    private Date createdat;
    private List<Marca> listBrand;
    private Marca selectedBrand;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public List<Marca> getListBrand() {
        return listBrand;
    }

    public void setListBrand(List<Marca> listBrand) {
        this.listBrand = listBrand;
    }

    public Marca getSelectedBrand() {
        return selectedBrand;
    }

    public void setSelectedBrand(Marca selectedBrand) {
        this.selectedBrand = selectedBrand;
    }
    
    
    
       
    
    @PostConstruct
    public void init(){
    
        listBrand = carsService.listBrand();
    
   }
    
    
    public String save(){
    
       Marca b= new Marca();
        
        b.setNombre(name);
        
        try{
            
            carsService.createBrand(b);
            
        
        }catch(org.springframework.dao.DataIntegrityViolationException e){
            Message("Brand already exists",FacesMessage.SEVERITY_ERROR);
            return null; 
        }
         listBrand.add(b);
         
         Message("Brand saved",FacesMessage.SEVERITY_INFO);
         
         name = null;
         return null;
  
    }
    
    
    public String deleteBrand(){
    
        try{

                carsService.deleteBrand(selectedBrand);


        }catch(RuntimeException ex){
            Message("Error",FacesMessage.SEVERITY_ERROR);
            return null; 
        }
        
        listBrand.remove(selectedBrand);    
        Message("Item Deleted",FacesMessage.SEVERITY_ERROR);

        
        return null;
    }
    
    
    public void Message(String text , FacesMessage.Severity severety){
  
      FacesMessage message = new FacesMessage(text);
      message.setSeverity(severety);
      FacesContext.getCurrentInstance().addMessage(null, message);
      
      
      
  }
    
    public MarcaController() {
    }
    
}

