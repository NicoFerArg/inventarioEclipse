package com.inventario.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Brands generated by hbm2java
 */
@Entity
@Table(name="marca"
    ,catalog="inventario"
    , uniqueConstraints = @UniqueConstraint(columnNames="nombre") 
)
public class Marca  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private Date fecha;
     private Set<Repuesto> partses = new HashSet<Repuesto>(0);
     private Set<Autos> carses = new HashSet<Autos>(0);

    public Marca() {
    }

	
    public Marca(int id) {
        this.id = id;
       
    }
    
    public Marca(String nombre, Date fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }
    public Marca(String nombre, Date fecha, Set<Repuesto> partses, Set<Autos> carses) {
       this.nombre = nombre;
       this.fecha = fecha;
       this.partses = partses;
       this.carses = carses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
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
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="marca")
    public Set<Repuesto> getPartses() {
        return this.partses;
    }
    
    public void setPartses(Set<Repuesto> partses) {
        this.partses = partses;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="marca")
    public Set<Autos> getCarses() {
        return this.carses;
    }
    
    public void setCarses(Set<Autos> carses) {
        this.carses = carses;
    }




}



