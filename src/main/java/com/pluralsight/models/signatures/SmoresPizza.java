package com.pluralsight.models.signatures;

import com.pluralsight.models.*;


// favorite piece of code!!
public class SmoresPizza extends Pizza {

    public SmoresPizza(Size size, CrustType crust) {
        super(size, crust);

        // dessert toppings (all regular)
        addTopping(new Topping("Chocolate Chips", ToppingCategory.REGULAR));
        addTopping(new Topping("Marshmallows", ToppingCategory.REGULAR));
        addTopping(new Topping("Graham Cracker Crumble", ToppingCategory.REGULAR));

        // dessert sauce
        addSauce(new Topping("Chocolate Drizzle", ToppingCategory.SAUCE));
    }

    public String getDescription() {
        return "Signature Dessert Pizza: S'mores\n" + super.getDescription();
    }
}
