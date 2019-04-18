package com.inventario.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="movimientos"
    ,catalog="inventario"
)
public class Movimientos  implements java.io.Serializable {


     private int id;
     private Cliente cliente;
     private Repuesto repuesto;
     private TipoMovimientos tipoMovimientos;
     private int cantidad;
     private Date fecha;

    public Movimientos() {
    }

    public Movimientos(int id, Cliente cliente, Repuesto repuesto, TipoMovimientos tipoMovimientos, int cantidad, Date fecha) {
       this.id = id;
       this.cliente = cliente;
       this.repuesto = repuesto;
       this.tipoMovimientos = tipoMovimientos;
       this.cantidad = cantidad;
       this.fecha = fecha;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idCliente", nullable=false)
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idRepuesto", nullable=false)
    public Repuesto getRepuesto() {
        return this.repuesto;
    }
    
    public void setRepuesto(Repuesto repuesto) {
        this.repuesto = repuesto;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idTipoMovimiento", nullable=false)
    public TipoMovimientos getTipoMovimientos() {
        return this.tipoMovimientos;
    }
    
    public void setTipoMovimientos(TipoMovimientos tipoMovimientos) {
        this.tipoMovimientos = tipoMovimientos;
    }

    
    @Column(name="cantidad", nullable=false)
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha", nullable=true, length=19)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}


