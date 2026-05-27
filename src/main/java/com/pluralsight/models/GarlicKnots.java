package com.pluralsight.models;

import com.pluralsight.IOrderItem;
import com.pluralsight.PriceCalculator;

//represents a garlic knots order added to an order.
public class GarlicKnots implements IOrderItem {

    //creates a garlic knots item.
    public GarlicKnots() {
    }

    //returns the flat price for garlic knots.
    public double getPrice() {
        return PriceCalculator.garlicKnotsPrice();
    }

    //returns a description for the order summary and receipt.
    public String getDescription() {
        return String.format("Garlic Knots  $%.2f", getPrice());
    }

    public String toString() {
        return getDescription();
    }
}