package com.pluralsight.models;

import com.pluralsight.IOrderItem;
import com.pluralsight.PriceCalculator;

import java.util.ArrayList;

public class Pizza implements IOrderItem {

    private Size size;
    private CrustType crustType;
    private boolean stuffedCrust;
    private ArrayList<Topping> toppings; // meats, cheeses, and regular toppings
    private ArrayList<Topping> sauces;   // kept separate for cleaner display on receipt

    //creates a pizza with the chosen size and crust.
    public Pizza(Size size, CrustType crustType) {
        this.size         = size;
        this.crustType    = crustType;
        this.stuffedCrust = false;
        this.toppings     = new ArrayList<Topping>();
        this.sauces       = new ArrayList<Topping>();
    }

    //returns the size of this pizza.
    public Size getSize() {
        return size;
    }

    //returns the crust type of this pizza
    public CrustType getCrustType() {
        return crustType;
    }

    public boolean isStuffedCrust() {
        return stuffedCrust;
    }

    //returns the list of toppings
    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    //returns the list of sauces on this pizza. */
    public ArrayList<Topping> getSauces() {
        return sauces;
    }


    // stuffed crust for this pizza
    public void setStuffedCrust(boolean stuffedCrust) {
        this.stuffedCrust = stuffedCrust;
    }

    //adds a topping (meat, cheese, or regular) to this pizza.

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    //adds a sauce to this pizza.

    public void addSauce(Topping sauce) {
        sauces.add(sauce);
    }

    // IOrderItem

    //calculates the total price for this pizza.

    public double getPrice() {
        double total = PriceCalculator.pizzaBasePrice(size);

        for (int i = 0; i < toppings.size(); i++) {
            total += toppings.get(i).getPriceFor(size);
        }

        for (int i = 0; i < sauces.size(); i++) {
            total += sauces.get(i).getPriceFor(size);
        }

        return total;
    }

    // a full description of this pizza for the order summary and receipt.
    public String getDescription() {
        String result = size + " Pizza - " + crustType + " crust";

        if (stuffedCrust) {
            result += " (stuffed)";
        }

        if (toppings.size() > 0) {
            result += "\n  Toppings:";
            for (int i = 0; i < toppings.size(); i++) {
                result += "\n    - " + toppings.get(i);
            }
        }

        if (sauces.size() > 0) {
            result += "\n  Sauces:";
            for (int i = 0; i < sauces.size(); i++) {
                result += "\n    - " + sauces.get(i);
            }
        }

        result += String.format("%n  Price: $%.2f", getPrice());

        return result;
    }

    public String toString() {
        return getDescription();
    }
}