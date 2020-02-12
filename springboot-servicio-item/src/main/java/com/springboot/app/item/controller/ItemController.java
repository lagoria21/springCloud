package com.springboot.app.item.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.app.item.models.Item;
import com.springboot.app.item.models.Producto;
import com.springboot.app.item.models.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    @Qualifier("serviceFeign")
   // @Qualifier("serviceRestTemplate")
    private ItemService itemService;

    @GetMapping("/listar")
    public List<Item> listar(){
        return itemService.findAll();
    }

  //  @HystrixCommand(fallbackMethod = "metodoAlternativo")
    @GetMapping("/ver/{id}/cantidad/{count}")
    public Item detalle(@PathVariable Long id, @PathVariable Integer count){
        return itemService.findById(id, count);
    }

    public Item metodoAlternativo(Long id, Integer count) {
        Item item = new Item();
        Producto producto = new Producto();

        item.setCount(count);
        producto.setId(id);
        producto.setName("Camara Sony");
        producto.setPrice(new BigDecimal(500));
        item.setProducto(producto);

        return item;
    }
}
