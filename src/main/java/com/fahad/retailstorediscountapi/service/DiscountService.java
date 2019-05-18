package com.fahad.retailstorediscountapi.service;

import com.fahad.retailstorediscountapi.dto.Order;
import com.fahad.retailstorediscountapi.dto.OrderInvoice;

import java.util.Date;

public interface DiscountService {

    boolean isDateTwoYearsOlder(Date inputDate);
    OrderInvoice getInvoice(Order order);
    Double loyaltyDiscount(Order order);
    int getAmountDiscount(Double productPriceAfterPercentDiscount);

}
