package com.springboot.app.item.models.service;

import com.springboot.app.item.models.Item;
import com.springboot.app.item.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate clientRest;

    @Override
    public List<Item> findAll() {
        List<Producto> productos = Arrays.asList(clientRest.getForObject("http://servicio-productos/listar", Producto[].class));
        return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer count) {
        Map<String, String> pathVariable = new HashMap<>();
        pathVariable.put("id", id.toString());
        Producto producto = clientRest.getForObject("http://servicio-productos/ver/{id}", Producto.class, pathVariable);
        return new Item(producto, count);
    }
}
