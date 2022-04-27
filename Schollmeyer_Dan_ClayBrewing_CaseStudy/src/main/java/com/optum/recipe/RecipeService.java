package com.optum.recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipes();
    Recipe getRecipeById(long id);
    Recipe getRecipeByName(String name);
}
