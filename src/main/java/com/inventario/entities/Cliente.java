package com.inventario.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="cliente",catalog="inventario"
)
public class Cliente  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
     private String nombre;
     private Date fecha;
     private Set<Movimientos> moveses = new HashSet<Movimientos>(0);

    public Cliente() {
    }
    
    public Cliente(int id) {
        this.id = id;
       
    }

	
    public Cliente(int id, String nombre, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
    }
    public Cliente(int id, String nombre, Date fecha, Set<Movimientos> moveses) {
       this.id = id;
       this.nombre = nombre;
       this.fecha = fecha;
       this.moveses = moveses;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="nombre", nullable=false, length=100)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha", nullable=false, length=19)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="cliente")
    public Set<Movimientos> getMoveses() {
        return this.moveses;
    }
    
    public void setMoveses(Set<Movimientos> moveses) {
        this.moveses = moveses;
    }




}
