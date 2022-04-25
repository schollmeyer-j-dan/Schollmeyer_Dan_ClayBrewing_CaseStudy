package com.optum.Ingredient;

public class IngredientNotFoundException extends RuntimeException {
    public IngredientNotFoundException(long id){
        super("Ingredient with id " +id+ " does not exist.");
    }
}
