package com.optum.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getAllIngredients();
    void saveIngredient(Ingredient Ingredient);
    Ingredient getIngredientById(long id);
    void deleteIngredientById(long id);
}
