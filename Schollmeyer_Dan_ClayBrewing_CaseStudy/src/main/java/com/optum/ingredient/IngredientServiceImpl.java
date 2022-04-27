package com.optum.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    private IngredientRepo ingredientRepo;

    @Autowired
    public IngredientServiceImpl(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepo.findAll();
    }

    @Override
    public void saveIngredient(Ingredient ingredient) {
        ingredientRepo.save(ingredient);
    }

    @Override
    public Ingredient getIngredientById(long id) {

        Optional<Ingredient> optionalIngredient = ingredientRepo.findById(id);
        if (optionalIngredient.isPresent()) {
            Ingredient ingredient = optionalIngredient.get();
            return ingredient;
        }
        throw new IngredientNotFoundException(id);
    }

    @Override
    public void deleteIngredientById(long id) {
        ingredientRepo.deleteById(id);
    }
}