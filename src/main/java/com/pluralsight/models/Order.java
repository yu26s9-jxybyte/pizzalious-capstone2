package com.pluralsight.models;

import com.pluralsight.IOrderItem;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {

    private ArrayList<IOrderItem> items;
    private Date orderTime;

    // Display format for screen
    private static final SimpleDateFormat DISPLAY_FORMAT =
            new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");

    // File format for receipt filename
    private static final SimpleDateFormat FILE_FORMAT =
            new SimpleDateFormat("yyyyMMdd-hhmmss");

    // Constructor
    public Order() {
        this.items = new ArrayList<>();
        this.orderTime = new Date();
    }

    // ITEM MANAGEMENT

    public void addItem(IOrderItem item) {
        items.add(item);
    }

    public ArrayList<IOrderItem> getItems() {
        return items;
    }

    public ArrayList<IOrderItem> getItemsNewestFirst() {
        ArrayList<IOrderItem> reversed = new ArrayList<>();

        for (int i = items.size() - 1; i >= 0; i--) {
            reversed.add(items.get(i));
        }

        return reversed;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    // ORDER VALIDATION

    public boolean isValid() {
        boolean hasPizza = false;
        boolean hasDrinkOrKnots = false;

        for (IOrderItem item : items) {
            if (item instanceof Pizza) {
                hasPizza = true;
            }
            if (item instanceof Drink || item instanceof GarlicKnots) {
                hasDrinkOrKnots = true;
            }
        }

        // valid if:
        // - at least one pizza OR
        // - at least one drink/knots
        return hasPizza || hasDrinkOrKnots;
    }

    // PRICING


    public double getTotalPrice() {
        double total = 0;

        for (IOrderItem item : items) {
            total += item.getPrice();
        }

        return total;
    }

    // RECEIPT INFO


    public String getReceiptFileName() {
        return FILE_FORMAT.format(orderTime) + ".txt";
    }

    public String getDisplayTime() {
        return DISPLAY_FORMAT.format(orderTime);
    }


    // ORDER SUMMARY

    public String getOrderSummary() {
        StringBuilder result = new StringBuilder();

        result.append("========================================\n");
        result.append("         PIZZA-licious Order\n");
        result.append("  ").append(getDisplayTime()).append("\n");
        result.append("========================================\n\n");

        if (items.isEmpty()) {
            result.append("  No items on this order.\n");
        } else {
            int index = 1;
            for (IOrderItem item : items) {
                result.append(index++)
                        .append(". ")
                        .append(item.getDescription())
                        .append("\n\n");
            }
        }

        result.append("----------------------------------------\n");
        result.append(String.format("  TOTAL:  $%.2f%n", getTotalPrice()));
        result.append("========================================\n");

        return result.toString();
    }
}
