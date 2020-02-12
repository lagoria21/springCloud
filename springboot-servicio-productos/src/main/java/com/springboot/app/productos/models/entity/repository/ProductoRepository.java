package com.springboot.app.productos.models.entity.repository;

import com.springboot.app.productos.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
