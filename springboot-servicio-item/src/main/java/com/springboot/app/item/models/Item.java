package com.springboot.app.item.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Builder(toBuilder=true)
public class Item {

    private Producto producto;
    private Integer count;

    public Item(Producto producto, Integer count) {
        this.producto = producto;
        this.count = count;
    }

    public BigDecimal getTotal() {

        BigDecimal itemCost = BigDecimal.ZERO;
        BigDecimal totalCost = BigDecimal.ZERO;

        itemCost = producto.getPrice().multiply(new BigDecimal(count));
        totalCost = totalCost.add(itemCost);
        return totalCost;

    }
}
