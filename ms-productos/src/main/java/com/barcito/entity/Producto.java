package com.barcito.entity;

import com.barcito.dto.ProductoDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "productos")
public class Producto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 

	@Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private int precio; 

    @Column(name = "tipo")
    private String tipo;

    public Producto(){
    	
    }
    
	public Producto(int id, @NotBlank(message = "El nombre no puede estar vacío") String nombre, String descripcion,
			@Positive(message = "El precio debe ser positivo") int precio,
			@NotBlank(message = "El tipo no puede estar vacío") String tipo) {
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
    
	public ProductoDto toDto() {
		return new ProductoDto(getId(), getNombre(), getDescripcion(), getPrecio(), getTipo());
	}
}
