package com.pluralsight.models;

import com.pluralsight.IOrderItem;
import com.pluralsight.PriceCalculator;

//represents a drink added to an order.
// implements IOrderItem so it can sit in the same order list as Pizza and GarlicKnots.
public class Drink implements IOrderItem {

    private Size size;
    private String flavor;

    //creates a drink with the given size and flavor.
    public Drink(Size size, String flavor) {
        this.size   = size;
        this.flavor = flavor;
    }

    //returns the size of this drink
    public Size getSize() {
        return size;
    }

    //returns the flavor of this drink.
    public String getFlavor() {
        return flavor;
    }

    //returns the price for this drink based on its size.
    public double getPrice() {
        return PriceCalculator.drinkPrice(size);
    }

    //returns a single-line description for the order summary and receipt.
    public String getDescription() {
        return String.format("%s Drink - %s  $%.2f", size, flavor, getPrice());
    }

    public String toString() {
        return getDescription();
    }
}