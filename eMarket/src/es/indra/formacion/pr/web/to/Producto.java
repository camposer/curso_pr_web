package es.indra.formacion.pr.web.to;

import java.io.Serializable;

// Transfer Object!
public class Producto implements Serializable {
	private static final long serialVersionUID = -8993835881084825842L;
	public static final int PRECIO_PORTATIL = 599;
	public static final int PRECIO_DVD = 60;
	public static final int PRECIO_CAMARA = 230;
	
	private Integer id;
	private String nombre;
	private Float precio;
	private Integer cantidad;
	
	public Producto() {	}
	
	public Producto(Integer id, String nombre, Float precio, Integer cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	public Producto(String nombre, Float precio) {
		this(null, nombre, precio, null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Float getTotal() {
		return cantidad * precio;
	}
}
