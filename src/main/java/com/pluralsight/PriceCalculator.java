package com.pluralsight;

// central source of truth for all pricing logic.
// all prices come directly from the requirements pricing table.
public class PriceCalculator {

    // Base pizza prices by size
    private static final double BASE_PERSONAL = 8.50;
    private static final double BASE_MEDIUM    = 12.00;
    private static final double BASE_LARGE     = 16.50;

    // meat topping prices by size
    private static final double MEAT_PERSONAL = 1.00;
    private static final double MEAT_MEDIUM   = 2.00;
    private static final double MEAT_LARGE    = 3.00;

    // extra meat upcharge per additional quantity
    private static final double EXTRA_MEAT_PERSONAL = 0.50;
    private static final double EXTRA_MEAT_MEDIUM   = 1.00;
    private static final double EXTRA_MEAT_LARGE    = 1.50;

    // cheese topping prices by size
    private static final double CHEESE_PERSONAL = 0.75;
    private static final double CHEESE_MEDIUM   = 1.50;
    private static final double CHEESE_LARGE    = 2.25;

    // extra cheese upcharge per additional quantity
    private static final double EXTRA_CHEESE_PERSONAL = 0.30;
    private static final double EXTRA_CHEESE_MEDIUM   = 0.60;
    private static final double EXTRA_CHEESE_LARGE    = 0.90;

    // drink prices by size
    private static final double DRINK_SMALL  = 2.00;
    private static final double DRINK_MEDIUM = 2.50;
    private static final double DRINK_LARGE  = 3.00;

    // sides
    private static final double GARLIC_KNOTS_PRICE = 1.50;

    // returns the base price for a pizza given its size. This covers the crust all crust types cost the same
    public static double pizzaBasePrice(Size size) {
        return switch (size) {
            case personal -> BASE_PERSONAL;
            case medium   -> BASE_MEDIUM;
            case large    -> BASE_LARGE;
        };
    }

    // Returns the price for a single meat topping based on pizza size
    // Does not include any extra-quantity upcharge — see extraMeatPrice()
    public static double meatPrice(Size size) {
        return switch (size) {
            case personal -> MEAT_PERSONAL;
            case medium   -> MEAT_MEDIUM;
            case large    -> MEAT_LARGE;
        };
    }

    // returns the extra upcharge per additional quantity of a meat topping.
    public static double extraMeatPrice(Size size) {
        return switch (size) {
            case personal -> EXTRA_MEAT_PERSONAL;
            case medium   -> EXTRA_MEAT_MEDIUM;
            case large    -> EXTRA_MEAT_LARGE;
        };
    }

    // returns the price for a single cheese topping based on pizza size
    // does not include any extra-quantity upcharge — see extraCheesePrice()
    public static double cheesePrice(Size size) {
        return switch (size) {
            case personal -> CHEESE_PERSONAL;
            case medium   -> CHEESE_MEDIUM;
            case large    -> CHEESE_LARGE;
        };
    }

    // returns the extra upcharge per additional quantity of a cheese topping
    // example: 2 extra mozzarella on a medium pizza = 2 * extraCheesePrice(MEDIUM)
    public static double extraCheesePrice(Size size) {
        return switch (size) {
            case personal -> EXTRA_CHEESE_PERSONAL;
            case medium   -> EXTRA_CHEESE_MEDIUM;
            case large    -> EXTRA_CHEESE_LARGE;
        };
    }

    // returns the price for a drink based on its size.
    // drinks use the same Size enum as pizzas (personal = small)
    public static double drinkPrice(Size size) {
        return switch (size) {
            case personal -> DRINK_SMALL;
            case medium   -> DRINK_MEDIUM;
            case large    -> DRINK_LARGE;
        };
    }

    // returns the flat price for a garlic knots order.
    public static double garlicKnotsPrice() {
        return GARLIC_KNOTS_PRICE;
    }
}