package com.pluralsight;

import com.pluralsight.models.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptWriter {

    public static void writeReceipt(Order order) {
        try {
            // create receipts folder if it doesn't exist
            File folder = new File("receipts");
            if (!folder.exists()) {
                folder.mkdir();
            }

            // build file path
            String fileName = "receipts/" + order.getReceiptFileName();
            FileWriter writer = new FileWriter(fileName);

            // write order summary
            writer.write(order.getOrderSummary());
            writer.close();

            System.out.println("\nReceipt saved as: " + fileName);

        } catch (IOException e) {
            System.out.println("Error writing receipt: " + e.getMessage());
        }
    }
}
