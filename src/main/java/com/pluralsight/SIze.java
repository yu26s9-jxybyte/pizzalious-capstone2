package com.pluralsight;

// the three available pizza (and drink) sizes.
public enum Size {
    personal("8\""),
    medium("12\""),
    large("16\"");

    private final String label;
    Size(String label) {
        this.label = label;
    }

    // returns the inch measurement, used in pricing lookups.
    public String getLabel() {
        return label;
    }

    // formats for display in menus
    public String toString() {
        String name = name();
        return name.charAt(0) + name.substring(1).toLowerCase() + " (" + label + ")";
    }
}
