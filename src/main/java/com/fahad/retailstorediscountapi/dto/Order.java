package com.fahad.retailstorediscountapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Order {

    private Customer customer;
    private List<Product> products = new ArrayList<>();
}
