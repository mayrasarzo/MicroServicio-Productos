package com.barcito.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.barcito.dto.ProductoDto;
import com.barcito.entity.Producto;
import com.barcito.service.ProductoService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductoDto>> listarProductos() throws Exception{
            List<Producto> productos = productoService.listarTodos();
            
            List<ProductoDto> dtos = new ArrayList<>();

            productos.forEach(x -> {
                dtos.add(x.toDto());
            });
            
            return new ResponseEntity<>(dtos, HttpStatus.OK);
    }


    @GetMapping(value = "/buscar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductoDto> buscarPorId(@PathVariable int id) throws Exception{
            Producto producto = productoService.buscarPorId(id);
           
            return new ResponseEntity<>(producto.toDto(), HttpStatus.OK);
    }

    /**
     * Agregar (Crear) un nuevo producto
     * POST /api/productos/agregar
     */
    
    @PostMapping(value = "/agregar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> agregarProducto(@Valid @RequestBody ProductoDto productoDto) throws Exception{
            productoService.guardar(productoDto);
            return new ResponseEntity<>(null, HttpStatus.OK); 
    }

    /**
     * Eliminar un producto
     * POST /api/productos/eliminar (no usado)
     */
    
    @PostMapping(value = "/eliminar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> eliminarProducto(@RequestBody Integer id) throws Exception{
            productoService.eliminarPorId(id);

            return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
