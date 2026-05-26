package com.pluralsight.models;

import com.pluralsight.IOrderItem;
import com.pluralsight.PriceCalculator;

import java.util.ArrayList;
import java.util.List;

// represents a single customized pizza on an order.
// holds all customer selections: size, crust, toppings, sauces, and stuffed crust.
// implements IOrderItem so it can be added to an Order like any other item.
public class Pizza implements IOrderItem {

    private final Size size;
    private final CrustType crustType;
    private boolean stuffedCrust;
    private final List<Topping> toppings; // meats, cheeses, and regular toppings
    private final List<Topping> sauces;   // sauces are tracked separately for cleaner display

    // creates a pizza with the given size and crust type.
    // stuffed crust defaults to false — use setStuffedCrust() to enable it.
    public Pizza(Size size, CrustType crustType) {
        this.size         = size;
        this.crustType    = crustType;
        this.stuffedCrust = false;
        this.toppings     = new ArrayList<>();
        this.sauces       = new ArrayList<>();
    }

    //getters

    //returns the size of this pizza.
    public Size getSize() {
        return size;
    }

    // returns the crust type selected for this pizza.
    public CrustType getCrustType() {
        return crustType;
    }

    // returns true if the customer requested stuffed crust.
    public boolean isStuffedCrust() {
        return stuffedCrust;
    }

    // returns the list of toppings (meats, cheeses, regular) on this pizza.
    public List<Topping> getToppings() {
        return toppings;
    }

    // returns the list of sauces selected for this pizza
    public List<Topping> getSauces() {
        return sauces;
    }

    // setters

    // enables or disables stuffed crust for this pizza
    public void setStuffedCrust(boolean stuffedCrust) {
        this.stuffedCrust = stuffedCrust;
    }

    // adding items

    // adds a topping (meat, cheese, or regular) to this pizza
    // sauces should be added via addSauce() instead
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    // adds a sauce to this pizza.
    // kept separate from toppings so the receipt can display them in distinct sections.
    public void addSauce(Topping sauce) {
        sauces.add(sauce);
    }

    // IOrderItem

    // calculates the total price for this pizza.
    // starts with the base price for the size, then adds the cost of each premium topping (meats and cheeses). Regular toppings
    // and sauces are always free so they contribute 0.0.
    public double getPrice() {
        double total = PriceCalculator.pizzaBasePrice(size);

        for (Topping topping : toppings) {
            total += topping.getPriceFor(size);
        }

        // sauces are always included, but we loop anyway in case pricing changes later
        for (Topping sauce : sauces) {
            total += sauce.getPriceFor(size);
        }

        return total;
    }

    // returns a full multi-line description of this pizza for the order summary and receipt.
    // lists size, crust, stuffed crust flag, each topping, and each sauce
    public String getDescription() {
        StringBuilder sb = new StringBuilder();

        sb.append(size).append(" Pizza - ").append(crustType).append(" crust");

        if (stuffedCrust) {
            sb.append(" (stuffed)");
        }

        if (!toppings.isEmpty()) {
            sb.append("\n  Toppings:");
            for (Topping t : toppings) {
                sb.append("\n    - ").append(t);
            }
        }

        if (!sauces.isEmpty()) {
            sb.append("\n  Sauces:");
            for (Topping s : sauces) {
                sb.append("\n    - ").append(s);
            }
        }

        sb.append(String.format("%n  Price: $%.2f", getPrice()));

        return sb.toString();
    }

    // delegates to getDescription() so Pizza prints cleanly wherever toString() is called.
    public String toString() {
        return getDescription();
    }
}