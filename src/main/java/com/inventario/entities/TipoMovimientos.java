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
import javax.persistence.UniqueConstraint;

/**
 * TypeMoves generated by hbm2java
 */
@Entity
@Table(name="tipoMovimientos"
    ,catalog="inventario"
    , uniqueConstraints = @UniqueConstraint(columnNames="nombre") 
)
public class TipoMovimientos  implements java.io.Serializable {


     private int id;
     private String nombre;
     private Date fecha;
     private Set<Movimientos> moveses = new HashSet<Movimientos>(0);

    public TipoMovimientos() {
    }
    
     public TipoMovimientos(int id) {
        this.id = id;
       
    }
    
    
    public TipoMovimientos(int id, String name, Date createdAt) {
        this.id = id;
        this.nombre = name;
        this.fecha = createdAt;
    }
    public TipoMovimientos(int id, String name, Date createdAt, Set<Movimientos> moveses) {
       this.id = id;
       this.nombre = name;
       this.fecha = createdAt;
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

    
    @Column(name="nombre", unique=true, nullable=false, length=100)
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
    
    public void setFecha(Date createdAt) {
        this.fecha = createdAt;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="tipoMovimientos")
    public Set<Movimientos> getMoveses() {
        return this.moveses;
    }
    
    public void setMoveses(Set<Movimientos> moveses) {
        this.moveses = moveses;
    }




}


