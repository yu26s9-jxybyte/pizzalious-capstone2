package com.pluralsight.models;

public enum Size {
    PERSONAL,
    MEDIUM,
    LARGE;

    //formats for display in menus, e.g. "Personal". */
    public String toString() {
        String name = name();
        return name.charAt(0) + name.substring(1).toLowerCase();
    }
}