package com.inventario.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="autos", catalog="inventario")
public class Autos implements java.io.Serializable{

	private Integer id;
	private Marca marcas;
    private String modelo;
    private int anio;
    private Date fecha;

    public Autos(){
    }
    
    public Autos(Marca marcas, String modelo, int anio, Date fecha) {
        this.marcas = marcas;
        this.modelo = modelo;
        this.anio = anio;
        this.fecha = fecha;
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
    @JoinColumn(name="idMarca", nullable=false)
    public Marca getMarcas() {
        return this.marcas;
    }
    
    public void setMarcas(Marca marcas) {
        this.marcas = marcas;
    }

    
    @Column(name="modelo", nullable=false, length=100)
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    
    @Column(name="anio", nullable=false)
    public int getAnio() {
        return this.anio;
    }
    
    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha", nullable=false, length=19)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

	
}
