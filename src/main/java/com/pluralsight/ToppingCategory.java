package com.pluralsight;

// determine how a topping is priced.
// meat and cheese are premium (extra cost per size)
// regular, sauce, and side are always included at no charge.
public enum ToppingCategory {
    meat,
    cheese,
    regular,
    sauce,
    side;

    // Formats for display in menus, e.g. "Meat", "Regular".
    public String toString() {
        String name = name();
        return name.charAt(0) + name.substring(1).toLowerCase();
    }
}
