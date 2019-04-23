package com.inventario.controller;

import com.inventario.entities.Cliente;
import com.inventario.entities.Movimientos;
import com.inventario.entities.Repuesto;
import com.inventario.entities.TipoMovimientos;
import com.inventario.model.service.AutosService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="movimientos")
@ViewScoped
public class MovimientoController implements Serializable {

    public static final long serialVersionUID = 1L;
    
    @ManagedProperty(value="#{autosService}")
    private AutosService carsService;

    public AutosService getCarsService() {
        return carsService;
    }

    public void setCarsService(AutosService carsService) {
        this.carsService = carsService;
    }
    
    private List<Movimientos> listMove;
    
    private int id;
    private List<Cliente> listClient;
    private List<TipoMovimientos> listTypeMove;
    private List<Repuesto> listPart;
    private int quantity;
    
    
    //////////
    
    private int id_client;
    private int id_typemove;
    private int id_part;

    public List<Movimientos> getListMove() {
        return listMove;
    }

    public void setListMove(List<Movimientos> listMove) {
        this.listMove = listMove;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Cliente> getListClient() {
        return listClient;
    }

    public void setListClient(List<Cliente> listClient) {
        this.listClient = listClient;
    }

    public List<TipoMovimientos> getListTypeMove() {
        return listTypeMove;
    }

    public void setListTypeMove(List<TipoMovimientos> listTypeMove) {
        this.listTypeMove = listTypeMove;
    }

    public List<Repuesto> getListPart() {
        return listPart;
    }

    public void setListPart(List<Repuesto> listPart) {
        this.listPart = listPart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_typemove() {
        return id_typemove;
    }

    public void setId_typemove(int id_typemove) {
        this.id_typemove = id_typemove;
    }

    public int getId_part() {
        return id_part;
    }

    public void setId_part(int id_part) {
        this.id_part = id_part;
    }
    
    
    
    @PostConstruct
    public void init(){
    
        listMove = carsService.listMove();
        
        listClient = carsService.listClient();
        listTypeMove = carsService.listTypeMove();
        listPart = carsService.listPart();
   
    }
    
    
    public String save_movimientos(){
    
       
       Cliente c= new Cliente(id_client);
       TipoMovimientos t = new TipoMovimientos(id_typemove);
       Repuesto p= new Repuesto(id_part);
       
       Movimientos m = new Movimientos(); 
       
       
       m.setCliente(c);
       m.setTipoMovimientos(t);
       m.setRepuesto(p);
       m.setCantidad(quantity);
           
        try{
            
            carsService.createMove(m);
            
        
        }catch(org.springframework.dao.DataIntegrityViolationException e){
            Message("Movimiento ya existe",FacesMessage.SEVERITY_ERROR);
            return null; 
        }
         listMove.add(m);
         
         Message("Movimiento guardado",FacesMessage.SEVERITY_INFO);
         
         quantity = 0;
         return null;
  
    }
    
    public String guardarMovimientos(){
    	
    	Cliente c = new Cliente(id_client);
    	TipoMovimientos t = new TipoMovimientos(id_typemove);
    	Repuesto p = new Repuesto(id_part);
    	
    	Movimientos m = new Movimientos();
    	
    	m.setCliente(c);
    	m.setTipoMovimientos(t);
    	m.setRepuesto(p);
    	m.setCantidad(quantity);
    	
    	try{
    		carsService.createMove(m);
    	}catch(org.springframework.dao.DataIntegrityViolationException e){
            Message("Movimiento ya existe",FacesMessage.SEVERITY_ERROR);
            return null; 
        }
         listMove.add(m);
         
         Message("Movimiento guardado",FacesMessage.SEVERITY_INFO);
    	
    	quantity = 0;
    	
    	return null;
    }
    
    
    
     public void Message(String text , FacesMessage.Severity severety){
  
        FacesMessage message = new FacesMessage(text);
        message.setSeverity(severety);
        FacesContext.getCurrentInstance().addMessage(null, message);
     }
    
    
 
    
    public MovimientoController(){
    }
    
}

