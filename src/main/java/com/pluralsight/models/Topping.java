package com.pluralsight.models;

import com.pluralsight.PriceCalculator;

// represents a single topping on a pizza.
public class Topping {

    private String name;
    private ToppingCategory category;
    private int extraQuantity; // number of extra portions beyond the standard one

    // creates a topping with no extras by default
    public Topping(String name, ToppingCategory category) {
        this.name          = name;
        this.category      = category;
        this.extraQuantity = 0;
    }

    // getters

    // returns the topping display name
    public String getName() {
        return name;
    }

    //returns the category,
    public ToppingCategory getCategory() {
        return category;
    }

    // returns how many extra portions of this topping were requested
    public int getExtraQuantity() {
        return extraQuantity;
    }

    // setters

    // sets the number of extra portions for this topping.
    public void setExtraQuantity(int extraQuantity) {
        if (extraQuantity >= 0) {
            this.extraQuantity = extraQuantity;
        }
    }

    // pricing

    // calculates the total cost of this topping for a given pizza size
    public double getPriceFor(Size size) {
        if (category == ToppingCategory.MEAT) {
            return PriceCalculator.meatPrice(size)
                    + (extraQuantity * PriceCalculator.extraMeatPrice(size));
        }

        if (category == ToppingCategory.CHEESE) {
            return PriceCalculator.cheesePrice(size)
                    + (extraQuantity * PriceCalculator.extraCheesePrice(size));
        }

        // REGULAR and SAUCE are always included at no charge
        return 0.0;
    }

    // displays string for the order summary and receipt and shows extras if any were added

    public String toString() {
        if (extraQuantity > 0) {
            return name + " (x" + extraQuantity + " extra)";
        }
        return name;
    }
}