package com.pluralsight.models;

// the four crust options a customer can choose from. all are the same base price.
public enum CrustType {
    thin,
    regular,
    thick,
    cauliflower;

    // Formats for display in menus, example: "Thin", "Cauliflower"
    public String toString() {
        String name = name();
        return name.charAt(0) + name.substring(1).toLowerCase();
    }
}