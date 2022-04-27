package com.optum.ingredient;

public class IngredientNotFoundException extends RuntimeException {
    public IngredientNotFoundException(long id){
        super("Ingredient with id " +id+ " does not exist.");
    }
}
