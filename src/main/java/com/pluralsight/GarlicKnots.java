package com.pluralsight;

public class GarlicKnots implements IOrderItem {

    // creates a garlic knots item.
    public GarlicKnots() {
    }

    // IOrderItem

    // returns the flat price for garlic knots
    public double getPrice() {
        return PriceCalculator.garlicKnotsPrice();
    }

    // description for the order summary and receipt.
    public String getDescription() {
        return String.format("Garlic Knots  $%.2f", getPrice());
    }

    // GarlicKnots prints cleanly wherever toString() is called.
    public String toString() {
        return getDescription();
    }
}