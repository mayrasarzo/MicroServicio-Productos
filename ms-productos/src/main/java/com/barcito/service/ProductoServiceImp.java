package com.barcito.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barcito.dto.ProductoDto;
import com.barcito.entity.Producto;
import com.barcito.repository.ProductoRepository;

@Service
public class ProductoServiceImp implements ProductoService{

	@Autowired
	private final ProductoRepository productoRepository;

	public ProductoServiceImp(ProductoRepository productoRepository) {
		super();
		this.productoRepository = productoRepository;
	}

	@Override
	public void guardar(ProductoDto productoDto) throws Exception {
        productoRepository.save(productoDto.toEntity());
	}

	@Override
	public List<Producto> listarTodos() throws Exception {
		List<Producto> productos = new ArrayList<>();
        
        productoRepository.findAll().forEach(x -> {
            productos.add(x);
        });
        
        return productos;
	}

	//no usados
	
	@Override
	public void eliminarPorId(int id) throws Exception {
        productoRepository.deleteById(id);
	}

	@Override
	public Producto buscarPorId(int id) throws Exception {
		Optional<Producto> productoOptional = productoRepository.findById(id);
	       
        if(productoOptional.isEmpty()) {
            throw new Exception("Producto no encontrado con id: " + id);
        }
        
        return productoOptional.get();
	}

}
