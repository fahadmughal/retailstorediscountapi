package com.fahad.retailstorediscountapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderInvoice {

    private Order order;
    private Double totalBillWithoutDiscount;
    private Double totalBillAfterDiscount;
}
