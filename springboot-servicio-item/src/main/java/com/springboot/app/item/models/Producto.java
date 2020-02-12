package com.springboot.app.item.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder=true)
public class Producto {

    private Long id;
    private String name;
    private BigDecimal price;
    private Date createAt;
    private Integer port;
}
