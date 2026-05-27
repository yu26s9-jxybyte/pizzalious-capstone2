package com.pluralsight.models;

public enum ToppingCategory {
    MEAT,
    CHEESE,
    REGULAR,
    SAUCE;


    public String toString() {
        String name = name();
        return name.charAt(0) + name.substring(1).toLowerCase();
    }
}