package com.fahad.retailstorediscountapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private int id;
    private String name;
    private Double price;
    private int quantity;

    private ProductType type;
}
