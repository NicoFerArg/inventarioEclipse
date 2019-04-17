package com.inventario.entities;

import javax.persistence.Entity;

@Entity
public class Movimientos {
	
	private int idVenta;
	private String rutCliente;
	private String repuesto;
	private String nombreAuto;
	private int cantidad;
	private int precio;
	private int precioTotal;
	
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public String getRutCliente() {
		return rutCliente;
	}
	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}
	public String getRepuesto() {
		return repuesto;
	}
	public void setRepuesto(String repuesto) {
		this.repuesto = repuesto;
	}
	public String getNombreAuto() {
		return nombreAuto;
	}
	public void setNombreAuto(String nombreAuto) {
		this.nombreAuto = nombreAuto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
	
}
