package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class BigmacBuilder {

    private Bun bun;
    private int burgers;
    private Sauce sauce;
    private final List<Ingredient> ingredients = new ArrayList<>();

    public BigmacBuilder bun(Bun bun) {
        this.bun = bun;
        return this;
    }

    public BigmacBuilder burgers(int burgers) {
        if (burgers < 1 || burgers > 3) {
            throw new IllegalStateException("Number of burgers must be between 1 and 3");
        }
        this.burgers = burgers;
        return this;
    }

    public BigmacBuilder sauce(Sauce sauce) {
        this.sauce = sauce;
        return this;
    }

    public BigmacBuilder ingredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    public Bigmac build() {
        return new Bigmac(bun, burgers, sauce, ingredients);
    }
}
