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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="repuesto"
    ,catalog="inventario"
)
public class Repuesto  implements java.io.Serializable {


     private Integer id;
     private Marca marca;
     private String nombre;
     private int stock;
     private int stockMin;
     private int stockMax;
     private Date fecha;
     private Set<Movimientos> moveses = new HashSet<Movimientos>(0);

    public Repuesto() {
    }
    
     public Repuesto(int id) {
        this.id = id;
    }

	
    public Repuesto(String name, int stock, int stockMin, int stockMax, Date createdAt) {
        this.nombre = name;
        this.stock = stock;
        this.stockMin = stockMin;
        this.stockMax = stockMax;
        this.fecha = createdAt;
    }
    public Repuesto(Marca brands, String name, int stock, int stockMin, int stockMax, Date createdAt, Set<Movimientos> moveses) {
       this.marca = brands;
       this.nombre = name;
       this.stock = stock;
       this.stockMin = stockMin;
       this.stockMax = stockMax;
       this.fecha = createdAt;
       this.moveses = moveses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idMarca")
    public Marca getMarca() {
        return this.marca;
    }
    
    public void setMarca(Marca brands) {
        this.marca = brands;
    }

    
    @Column(name="nombre", nullable=false, length=100)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="stock", nullable=false)
    public int getStock() {
        return this.stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }

    
    @Column(name="stockMin", nullable=false)
    public int getStockMin() {
        return this.stockMin;
    }
    
    public void setStockMin(int stockMin) {
        this.stockMin = stockMin;
    }

    
    @Column(name="stockMax", nullable=false)
    public int getStockMax() {
        return this.stockMax;
    }
    
    public void setStockMax(int stockMax) {
        this.stockMax = stockMax;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha", nullable=false, length=19)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="repuesto")
    public Set<Movimientos> getMoveses() {
        return this.moveses;
    }
    
    public void setMoveses(Set<Movimientos> moveses) {
        this.moveses = moveses;
    }




}

