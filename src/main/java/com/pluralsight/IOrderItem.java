package com.pluralsight;

// common contract for everything that can be added to an Order.
// pizza, Drink, and GarlicKnots all implement this so Orders can hold them in one list without caring about the concrete type.
public interface IOrderItem {

    // returns the total price for this item in dollars.
    double getPrice();

    // returns a readable summary shown on the order screen and receipt
    String getDescription();
}