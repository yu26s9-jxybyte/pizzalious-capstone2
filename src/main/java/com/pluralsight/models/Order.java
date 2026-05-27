package com.pluralsight.models;

import com.pluralsight.IOrderItem;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

// holds all items added during the session and records the time the order was created for the receipt filename.
public class Order {

    private ArrayList<IOrderItem> items;
    private Date orderTime;

    // formats the date for display on screen
    private static final SimpleDateFormat DISPLAY_FORMAT =
            new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");

    // formats the date for the receipt filename
    private static final SimpleDateFormat FILE_FORMAT =
            new SimpleDateFormat("yyyyMMdd-hhmmss");

    // creates a new empty order and captures the current date and time.
    public Order() {
        this.items     = new ArrayList<IOrderItem>();
        this.orderTime = new Date();
    }

    // managing items

    // adds any IOrderItem (Pizza, Drink, or GarlicKnots) to this order.
    public void addItem(IOrderItem item) {
        items.add(item);
    }

    //getters

    // returns the items in reverse order so the newest shows up first.
    public ArrayList<IOrderItem> getItemsNewestFirst() {
        ArrayList<IOrderItem> reversed = new ArrayList<IOrderItem>();

        for (int i = items.size() - 1; i >= 0; i--) {
            reversed.add(items.get(i));
        }

        return reversed;
    }

    //returns the items in the order they were added. used when building the receipt.
    public ArrayList<IOrderItem> getItems() {
        return items;
    }

    //returns true if there are no items on the order yet.
    public boolean isEmpty() {
        return items.size() == 0;
    }

    //returns the receipt filename based on the order timestamp.
    public String getReceiptFileName() {
        return FILE_FORMAT.format(orderTime) + ".txt";
    }

    //returns the order time formatted for display on screen.
    public String getDisplayTime() {
        return DISPLAY_FORMAT.format(orderTime);
    }

    //returns true if this order meets the minimum requirements to check out.
    public boolean isValid() {
        boolean hasPizza        = false;
        boolean hasDrinkOrKnots = false;

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) instanceof Pizza) {
                hasPizza = true;
            }
            if (items.get(i) instanceof Drink || items.get(i) instanceof GarlicKnots) {
                hasDrinkOrKnots = true;
            }
        }

        return hasPizza || hasDrinkOrKnots;
    }

    // pricing

    //returns the grand total by adding up the price of every item on the order.
    public double getTotalPrice() {
        double total = 0;

        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getPrice();
        }

        return total;
    }

    // display

    // builds the full order summary shown on the checkout screen and saved to the receipt
    // lists every item with its description, then shows the grand total.

    public String getOrderSummary() {
        String result = "";

        result += "========================================\n";
        result += "         PIZZA-licious Order\n";
        result += "  " + getDisplayTime() + "\n";
        result += "========================================\n\n";

        if (items.size() == 0) {
            result += "  No items on this order.\n";
        } else {
            for (int i = 0; i < items.size(); i++) {
                result += (i + 1) + ". " + items.get(i).getDescription() + "\n\n";
            }
        }

        result += "----------------------------------------\n";
        result += String.format("  TOTAL:  $%.2f%n", getTotalPrice());
        result += "========================================\n";

        return result;
    }
}