package com.fahad.retailstorediscountapi.controller;

import com.fahad.retailstorediscountapi.dto.Order;
import com.fahad.retailstorediscountapi.dto.OrderInvoice;
import com.fahad.retailstorediscountapi.dto.Product;
import com.fahad.retailstorediscountapi.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public OrderInvoice processDiscount(@Valid @RequestBody Order order) {
        return discountService.getInvoice(order);
    }
}
