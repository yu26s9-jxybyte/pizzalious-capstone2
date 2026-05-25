package com.pluralsight;

// represents a single topping on a pizza.
// tracks how many of this topping were added (quantity) and how many extras were requested on top of that (extraQuantity).
// pricing is delegated to PriceCalculator — Topping only stores data
public class Topping {

    private final String name;
    private final ToppingCategory category;
    private int extraQuantity; // number of extra portions requested beyond the first

    // Creates a topping with a default quantity of 1 and no extras
    // display name "Pepperoni"
    // determines whether this topping costs extra (meat/cheese) or is free
    public Topping(String name, ToppingCategory category) {
        this.name          = name;
        this.category      = category;
        this.extraQuantity = 0;
    }

    //getters

    // returns the topping's display name
    public String getName() {
        return name;
    }

    // returns the category, which drives pricing logic in PriceCalculator
    public ToppingCategory getCategory() {
        return category;
    }

    // returns how many extra portions of this topping were requested
    public int getExtraQuantity() {
        return extraQuantity;
    }

    // setters

    // sets the number of extra portions for this topping.
    // must be 0 or greater — negative values are ignored.
    public void setExtraQuantity(int extraQuantity) {
        if (extraQuantity >= 0) {
            this.extraQuantity = extraQuantity;
        }
    }

    //pricing

    // Calculates the total cost of this topping for a given pizza size.
    // regular, sauce, side: always free, returns 0.0
    // meat: base meat price + (extraQuantity * extra meat upcharge)
    // cheese: base cheese price + (extraQuantity * extra cheese upcharge)
    // size the size of the pizza this topping belongs to
     // return the total price for this topping in dollars
    public double getPriceFor(Size size) {
        return switch (category) {
            case meat -> PriceCalculator.meatPrice(size)
                    + (extraQuantity * PriceCalculator.extraMeatPrice(size));

            case cheese -> PriceCalculator.cheesePrice(size)
                    + (extraQuantity * PriceCalculator.extraCheesePrice(size));

            // regular toppings, sauces, and sides are always included at no charge
            case regular, sauce, side -> 0.0;
        };
    }

    // ---------- Display ----------

    // returns a display string for receipts and order summaries.
    // shows extras if any were requested, "Pepperoni (x2 extra)".
    public String toString() {
        String base = name;
        if (extraQuantity > 0) {
            base += " (x" + extraQuantity + " extra)";
        }
        return base;
    }
}