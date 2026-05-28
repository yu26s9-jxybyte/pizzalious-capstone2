package com.pluralsight.models.signatures;

import com.pluralsight.models.*;

public class AppleCinnamonCrumblePizza extends Pizza {

    public AppleCinnamonCrumblePizza(Size size, CrustType crust) {
        super(size, crust);

        addTopping(new Topping("Apple Slices", ToppingCategory.REGULAR));
        addTopping(new Topping("Cinnamon Sugar", ToppingCategory.REGULAR));
        addTopping(new Topping("Brown Sugar Crumble", ToppingCategory.REGULAR));

        addSauce(new Topping("Caramel Drizzle", ToppingCategory.SAUCE));
    }

    public String getDescription() {
        return "Signature Dessert Pizza: Apple Cinnamon Crumble\n" + super.getDescription();
    }
}
