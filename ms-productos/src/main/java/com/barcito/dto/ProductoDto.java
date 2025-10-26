package com.barcito.dto;

import com.barcito.entity.Producto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProductoDto {
	private int id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    private String descripcion;

    @Positive(message = "El precio debe ser positivo")
    private int precio;

    @NotBlank(message = "El tipo no puede estar vacío")
    private String tipo;
    
    public ProductoDto(){
    	
    }
    
	public ProductoDto(int id, String nombre, String descripcion, int precio, String tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
    
	public Producto toEntity() {
        return new Producto(getId(), getNombre(), getDescripcion(), getPrecio(), getTipo());
    }
}
