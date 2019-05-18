package com.fahad.retailstorediscountapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Customer {

    private int id;
    private String name;
    private Date createdAt;


    private CustomerType type;

}
