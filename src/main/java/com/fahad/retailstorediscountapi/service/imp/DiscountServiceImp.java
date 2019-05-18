package com.fahad.retailstorediscountapi.service.imp;

import com.fahad.retailstorediscountapi.dto.Order;
import com.fahad.retailstorediscountapi.dto.OrderInvoice;
import com.fahad.retailstorediscountapi.dto.Product;
import com.fahad.retailstorediscountapi.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DiscountServiceImp implements DiscountService {


    /*TODO Checking Two Years old or not*/
    @Override
    public boolean isDateTwoYearsOlder(Date inputDate) {
        Date d = new Date();
        long dLong = d.getTime();
        long twoYearAgo = dLong - (730 * 24 * 60 * 60 * 1000);

        return inputDate.getTime() > twoYearAgo;
    }

    /*TODO Calculating % Discount*/
    @Override
    public Double loyaltyDiscount(Order order) {
        /*TODO Employee % Discount*/
        if(order.getCustomer().getType().getId() == 1)
        {
            return  0.3;
        }
        else if(order.getCustomer().getType().getId() == 2)
        {
            return 0.1;
        }
        else if(order.getCustomer().getType().getId() == 3
                && isDateTwoYearsOlder(order.getCustomer().getCreatedAt()))
        {
            return 0.05;
        }
        else {
            return 0.0;
        }
    }

    /*TODO Calculating Amount Discount*/
    @Override
    public int getAmountDiscount(Double productPriceAfterPercentDiscount) {
        return (int)(productPriceAfterPercentDiscount / 100) * 5;
    }

    /*TODO Generating Invoice*/
    @Override
    public OrderInvoice getInvoice(Order order) {
        OrderInvoice orderInvoice = new OrderInvoice();
        orderInvoice.setTotalBillWithoutDiscount(0.0);
        Double productPriceByQuantity;
        Double productPriceAfterPercentDiscount = 0.0;
        for(Product product : order.getProducts())
        {
            productPriceByQuantity = product.getPrice() * product.getQuantity();
            /*TODO For !Grocery*/
            if(product.getType().getId() != 1)
            {
                orderInvoice.setTotalBillWithoutDiscount(orderInvoice.getTotalBillWithoutDiscount() + productPriceByQuantity);
                productPriceAfterPercentDiscount += (productPriceByQuantity - productPriceByQuantity * loyaltyDiscount(order));
            }
            else {
                orderInvoice.setTotalBillWithoutDiscount(orderInvoice.getTotalBillWithoutDiscount() + productPriceByQuantity);
                productPriceAfterPercentDiscount += productPriceByQuantity;
            }
        }

        orderInvoice.setTotalBillAfterDiscount(productPriceAfterPercentDiscount
                - getAmountDiscount(productPriceAfterPercentDiscount));
        orderInvoice.setOrder(order);

        return orderInvoice;
    }
}
