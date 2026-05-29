package com.pluralsight;

import com.pluralsight.models.*;
import com.pluralsight.models.signatures.AppleCinnamonCrumblePizza;
import com.pluralsight.models.signatures.SmoresPizza;
import com.pluralsight.models.signatures.StrawberryCheesecakePizza;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    // PRESET TOPPING LISTS

    private static final String[] MEAT_TOPPINGS = {
            "Pepperoni", "Sausage", "Ham", "Bacon", "Chicken"
    };

    private static final String[] CHEESE_TOPPINGS = {
            "Mozzarella", "Cheddar", "Parmesan", "Feta", "Provolone"
    };

    private static final String[] REGULAR_TOPPINGS = {
            "Mushrooms", "Onions", "Green Peppers", "Olives", "Spinach", "Pineapple"
    };

    private static final String[] SAUCE_OPTIONS = {
            "Marinara", "Alfredo", "Pesto", "BBQ", "Buffalo", "Olive Oil"
    };

    private static final String[] DRINK_FLAVORS = {
            "Coke", "Sprite", "Root Beer", "Lemonade", "Iced Tea"
    };

    // MAIN MENU

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== PIZZA-licious ===");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");

            int choice = readInt();

            switch (choice) {
                case 1:
                    startNewOrder();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        System.out.println("Goodbye!");
    }

    // order flow

    private static void startNewOrder() {
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n=== Order Menu ===");
            System.out.println("1) Add Pizza");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Garlic Knots");
            System.out.println("4) Add Signature Dessert Pizza");
            System.out.println("5) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");

            int choice = readInt();

            switch (choice) {
                case 1:
                    order.addItem(buildPizza());
                    break;
                case 2:
                    order.addItem(buildDrink());
                    break;
                case 3:
                    order.addItem(new GarlicKnots());
                    System.out.println("Garlic knots added.");
                    break;
                case 4:
                    order.addItem(buildSignatureDessertPizza());
                    System.out.println("Signature dessert pizza added!");
                    break;
                case 5:
                    checkout(order);
                    ordering = false;
                    break;
                case 0:
                    System.out.println("Order canceled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // BUILD PIZZA

    private static Pizza buildPizza() {
        System.out.println("\n=== Build Your Pizza ===");

        Size size = chooseSize();
        CrustType crust = chooseCrust();

        Pizza pizza = new Pizza(size, crust);

        addToppings(pizza);
        addSauces(pizza);

        System.out.print("Stuffed crust? (y/n): ");
        pizza.setStuffedCrust(scanner.nextLine().trim().equalsIgnoreCase("y"));

        System.out.println("\nPizza added!");
        return pizza;
    }

    private static Size chooseSize() {
        System.out.println("\nChoose size:");
        System.out.println("1) Personal");
        System.out.println("2) Medium");
        System.out.println("3) Large");
        System.out.print("Choose: ");

        int choice = readInt();

        switch (choice) {
            case 1: return Size.PERSONAL;
            case 2: return Size.MEDIUM;
            case 3: return Size.LARGE;
            default:
                System.out.println("Invalid. Defaulting to Personal.");
                return Size.PERSONAL;
        }
    }

    private static CrustType chooseCrust() {
        System.out.println("\nChoose crust:");
        System.out.println("1) Thin");
        System.out.println("2) Regular");
        System.out.println("3) Thick");
        System.out.println("4) Cauliflower");
        System.out.print("Choose: ");

        int choice = readInt();

        switch (choice) {
            case 1: return CrustType.THIN;
            case 2: return CrustType.REGULAR;
            case 3: return CrustType.THICK;
            case 4: return CrustType.CAULIFLOWER;
            default:
                System.out.println("Invalid. Defaulting to Regular.");
                return CrustType.REGULAR;
        }
    }

    private static void addToppings(Pizza pizza) {
        boolean adding = true;

        while (adding) {
            System.out.println("\nAdd Toppings:");
            System.out.println("1) Meat");
            System.out.println("2) Cheese");
            System.out.println("3) Regular Topping");
            System.out.println("0) Done");
            System.out.print("Choose: ");

            int choice = readInt();

            switch (choice) {
                case 1:
                    addToppingOfType(pizza, ToppingCategory.MEAT);
                    break;
                case 2:
                    addToppingOfType(pizza, ToppingCategory.CHEESE);
                    break;
                case 3:
                    addToppingOfType(pizza, ToppingCategory.REGULAR);
                    break;
                case 0:
                    adding = false;
                    break;
                default:
                    System.out.println("Invalid.");
            }
        }
    }

    private static void addSauces(Pizza pizza) {
        boolean adding = true;

        while (adding) {
            System.out.println("\nAdd Sauces:");

            for (int i = 0; i < SAUCE_OPTIONS.length; i++) {
                System.out.println((i + 1) + ") " + SAUCE_OPTIONS[i]);
            }
            System.out.println("0) Done");
            System.out.print("Choose: ");

            int choice = readInt();

            if (choice == 0) {
                adding = false;
            } else if (choice >= 1 && choice <= SAUCE_OPTIONS.length) {
                pizza.addSauce(new Topping(SAUCE_OPTIONS[choice - 1], ToppingCategory.SAUCE));
                System.out.println("Added: " + SAUCE_OPTIONS[choice - 1]);
            } else {
                System.out.println("Invalid.");
            }
        }
    }

    private static void addToppingOfType(Pizza pizza, ToppingCategory category) {

        String[] list;

        if (category == ToppingCategory.MEAT) {
            list = MEAT_TOPPINGS;
        } else if (category == ToppingCategory.CHEESE) {
            list = CHEESE_TOPPINGS;
        } else {
            list = REGULAR_TOPPINGS;
        }

        System.out.println("\nChoose a " + category.toString() + " topping:");

        for (int i = 0; i < list.length; i++) {
            System.out.println((i + 1) + ") " + list[i]);
        }
        System.out.println("0) Cancel");

        System.out.print("Choose: ");
        int choice = readInt();

        if (choice < 1 || choice > list.length) {
            System.out.println("Canceled.");
            return;
        }

        String name = list[choice - 1];
        Topping topping = new Topping(name, category);

        if (category == ToppingCategory.MEAT || category == ToppingCategory.CHEESE) {
            System.out.print("How many extra portions? (0 for none): ");
            topping.setExtraQuantity(readInt());
        }

        pizza.addTopping(topping);
        System.out.println("Added: " + topping.toString());
    }

    // BUILD DRINK

    private static Drink buildDrink() {
        System.out.println("\n=== Add Drink ===");

        Size size = chooseSize();

        System.out.println("\nChoose drink flavor:");
        for (int i = 0; i < DRINK_FLAVORS.length; i++) {
            System.out.println((i + 1) + ") " + DRINK_FLAVORS[i]);
        }
        System.out.print("Choose: ");

        int choice = readInt();
        String flavor = (choice >= 1 && choice <= DRINK_FLAVORS.length)
                ? DRINK_FLAVORS[choice - 1]
                : "Unknown";

        System.out.println("Drink added!");
        return new Drink(size, flavor);
    }

    // DESSERTS
    private static Pizza buildSignatureDessertPizza() {
        System.out.println("\nChoose a Signature Dessert Pizza:");
        System.out.println("1) S'mores Pizza");
        System.out.println("2) Strawberry Cheesecake Pizza");
        System.out.println("3) Apple Cinnamon Crumble Pizza");
        System.out.print("Choose: ");

        int choice = readInt();

        Size size = chooseSize();
        CrustType crust = chooseCrust();

        switch (choice) {
            case 1:
                return new SmoresPizza(size, crust);
            case 2:
                return new StrawberryCheesecakePizza(size, crust);
            case 3:
                return new AppleCinnamonCrumblePizza(size, crust);


            default:
                System.out.println("Invalid. Defaulting to S'mores.");
                return new SmoresPizza(size, crust);
        }
    }


    // CHECKOUT

    private static void checkout(Order order) {
        if (!order.isValid()) {
            System.out.println("\nOrder does not meet minimum requirements.");
            return;
        }

        System.out.println("\n=== Checkout ===");
        System.out.println(order.getOrderSummary());

        System.out.println("1) Confirm");
        System.out.println("0) Cancel");
        System.out.print("Choose: ");

        int choice = readInt();

        if (choice == 1) {
            ReceiptWriter.writeReceipt(order);
            System.out.println("Order completed!");
        } else {
            System.out.println("Checkout canceled.");
        }
    }

    private static int readInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }
}
