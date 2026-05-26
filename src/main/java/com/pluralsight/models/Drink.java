package com.pluralsight.models;

import com.pluralsight.IOrderItem;
import com.pluralsight.PriceCalculator;

// customers choose a size and a flavor.
// it also implements IOrderItem so it can live in the same order list as Pizza and GarlicKnots
public class Drink implements IOrderItem {

    private final Size size;
    private final String flavor;

    // creates a drink with the given size and flavor
     // size personal = small, medium = medium, large = large
     // flavor customer's choice of drink flavor
    public Drink(Size size, String flavor) {
        this.size   = size;
        this.flavor = flavor;
    }

    //getters
    //returns the size of this drink
    public Size getSize() {
        return size;
    }

    // returns the flavor of this drink.
    public String getFlavor() {
        return flavor;
    }

    //IOrderItem

    // Returns the price for this drink based on its size.
    // delegates to PriceCalculator

    public double getPrice() {
        return PriceCalculator.drinkPrice(size);
    }

    // returns a single-line description for the order summary and receipt.
    public String getDescription() {
        return String.format("%s Drink - %s  $%.2f", size, flavor, getPrice());
    }

    // prints cleanly wherever toString() is called.

    public String toString() {
        return getDescription();
    }
}