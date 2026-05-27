package com.pluralsight.models;

public enum CrustType {
    THIN,
    REGULAR,
    THICK,
    CAULIFLOWER;

    public String toString() {
        String name = name();
        return name.charAt(0) + name.substring(1).toLowerCase();
    }
}