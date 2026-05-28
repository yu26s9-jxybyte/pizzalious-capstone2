package com.pluralsight.models.signatures;

import com.pluralsight.models.*;

public class StrawberryCheesecakePizza extends Pizza {

    public StrawberryCheesecakePizza(Size size, CrustType crust) {
        super(size, crust);

        addTopping(new Topping("Strawberries", ToppingCategory.REGULAR));
        addTopping(new Topping("Cream Cheese Dollops", ToppingCategory.CHEESE));
        addTopping(new Topping("Graham Cracker Crust Bits", ToppingCategory.REGULAR));

        addSauce(new Topping("Strawberry Glaze", ToppingCategory.SAUCE));
    }

    public String getDescription() {
        return "Signature Dessert Pizza: Strawberry Cheesecake\n" + super.getDescription();
    }
}
