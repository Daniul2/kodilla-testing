package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BigmacTestSuite {
    @Test
    void testBigmacBuilder(){
        //Given
        Bigmac bigmac = new BigmacBuilder()
                .bun(Bun.SESAME)
                .burgers(2)
                .sauce(Sauce.BARBECUE)
                .ingredient(Ingredient.LETTUCE)
                .ingredient(Ingredient.BACON)
                .ingredient(Ingredient.CHEESE)
                .build();
        System.out.println(bigmac);

        //When
        int ingredientsCount = bigmac.getIngredients().size();


        //Then
        assertEquals(3, ingredientsCount);
        assertEquals(Bun.SESAME, bigmac.getBun());
        assertEquals(2, bigmac.getBurgers());
        assertEquals(Sauce.BARBECUE, bigmac.getSauce());
    }
}
