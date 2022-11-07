package com.twu.refactoring;

import java.util.List;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {

    private final Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append("======Printing Orders======\n");
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription()).append('\t');
            output.append(lineItem.getPrice()).append('\t');
            output.append(lineItem.getQuantity()).append('\t');
            output.append(lineItem.getLineItemTotalAmount()).append('\n');
        }

        output.append("Total Sales Tax").append('\t').append(calculateOrderTotalSalesTax(order.getLineItems()));
        output.append("Total Amount").append('\t').append(calculateOrderTotalAmount(order.getLineItems()));
        return output.toString();
    }

    private double calculateOrderTotalSalesTax(List<LineItem> lineItems) {
        double totalSalesTax = 0d;
        for (LineItem lineItem : lineItems) {
            double salesTax = calculateSalesTaxByTenPercent(lineItem);
            totalSalesTax += salesTax;
        }
        return totalSalesTax;
    }

    private double calculateOrderTotalAmount(List<LineItem> lineItems) {
        double orderTotalAmount = 0d;
        for (LineItem lineItem : lineItems) {
            double salesTaxByTenPercent = calculateSalesTaxByTenPercent(lineItem);
            orderTotalAmount += lineItem.getLineItemTotalAmount() + salesTaxByTenPercent;
        }
        return orderTotalAmount;
    }

    private double calculateSalesTaxByTenPercent(LineItem lineItem) {
        return lineItem.getLineItemTotalAmount() * .10;
    }
}