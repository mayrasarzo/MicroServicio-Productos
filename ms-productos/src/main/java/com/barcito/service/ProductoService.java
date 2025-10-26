package com.barcito.service;

import java.util.List;

import com.barcito.dto.ProductoDto;
import com.barcito.entity.Producto;

public interface ProductoService {
	public void guardar(ProductoDto productoDto) throws Exception;
    public List<Producto> listarTodos() throws Exception;
    
    //no usados
    public void eliminarPorId(int id) throws Exception;
    public Producto buscarPorId(int id) throws Exception;
}
