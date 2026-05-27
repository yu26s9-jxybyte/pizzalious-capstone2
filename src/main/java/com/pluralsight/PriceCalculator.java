package com.pluralsight;

import com.pluralsight.models.Size;

//all prices come directly from the requirements pricing table.

public class PriceCalculator {

    // Base pizza prices by size (covers any crust type)
    private static final double BASE_PERSONAL = 8.50;
    private static final double BASE_MEDIUM   = 12.00;
    private static final double BASE_LARGE    = 16.50;

    // Meat topping prices by size
    private static final double MEAT_PERSONAL = 1.00;
    private static final double MEAT_MEDIUM   = 2.00;
    private static final double MEAT_LARGE    = 3.00;

    // Extra meat upcharge per additional quantity
    private static final double EXTRA_MEAT_PERSONAL = 0.50;
    private static final double EXTRA_MEAT_MEDIUM   = 1.00;
    private static final double EXTRA_MEAT_LARGE    = 1.50;

    // Cheese topping prices by size
    private static final double CHEESE_PERSONAL = 0.75;
    private static final double CHEESE_MEDIUM   = 1.50;
    private static final double CHEESE_LARGE    = 2.25;

    // Extra cheese upcharge per additional quantity
    private static final double EXTRA_CHEESE_PERSONAL = 0.30;
    private static final double EXTRA_CHEESE_MEDIUM   = 0.60;
    private static final double EXTRA_CHEESE_LARGE    = 0.90;

    // Drink prices by size
    private static final double DRINK_PERSONAL = 2.00;
    private static final double DRINK_MEDIUM   = 2.50;
    private static final double DRINK_LARGE    = 3.00;

    // Flat price for garlic knots
    private static final double GARLIC_KNOTS_PRICE = 1.50;

    //returns the base price for a pizza given its size.

    public static double pizzaBasePrice(Size size) {
        if (size == Size.PERSONAL) return BASE_PERSONAL;
        if (size == Size.MEDIUM)   return BASE_MEDIUM;
        if (size == Size.LARGE)    return BASE_LARGE;
        return 0.0;
    }

    //returns the price for one meat topping based on pizza size.

    public static double meatPrice(Size size) {
        if (size == Size.PERSONAL) return MEAT_PERSONAL;
        if (size == Size.MEDIUM)   return MEAT_MEDIUM;
        if (size == Size.LARGE)    return MEAT_LARGE;
        return 0.0;
    }

    //returns the upcharge per extra portion of a meat topping.

    public static double extraMeatPrice(Size size) {
        if (size == Size.PERSONAL) return EXTRA_MEAT_PERSONAL;
        if (size == Size.MEDIUM)   return EXTRA_MEAT_MEDIUM;
        if (size == Size.LARGE)    return EXTRA_MEAT_LARGE;
        return 0.0;
    }

    //returns the price for one cheese topping based on pizza size.
    public static double cheesePrice(Size size) {
        if (size == Size.PERSONAL) return CHEESE_PERSONAL;
        if (size == Size.MEDIUM)   return CHEESE_MEDIUM;
        if (size == Size.LARGE)    return CHEESE_LARGE;
        return 0.0;
    }

    //returns the upcharge per extra portion of a cheese topping.
    public static double extraCheesePrice(Size size) {
        if (size == Size.PERSONAL) return EXTRA_CHEESE_PERSONAL;
        if (size == Size.MEDIUM)   return EXTRA_CHEESE_MEDIUM;
        if (size == Size.LARGE)    return EXTRA_CHEESE_LARGE;
        return 0.0;
    }

    //returns the price for a drink based on its size.

    public static double drinkPrice(Size size) {
        if (size == Size.PERSONAL) return DRINK_PERSONAL;
        if (size == Size.MEDIUM)   return DRINK_MEDIUM;
        if (size == Size.LARGE)    return DRINK_LARGE;
        return 0.0;
    }

    //returns the flat price for garlic knots.
    public static double garlicKnotsPrice() {
        return GARLIC_KNOTS_PRICE;
    }
}
