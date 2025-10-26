package com.barcito.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.barcito.entity.Producto;


@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer>{
	
}
