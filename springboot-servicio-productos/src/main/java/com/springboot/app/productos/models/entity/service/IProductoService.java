package com.springboot.app.productos.models.entity.service;

import com.springboot.app.productos.models.entity.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> findAll();

    Producto findById(Long id);
}
