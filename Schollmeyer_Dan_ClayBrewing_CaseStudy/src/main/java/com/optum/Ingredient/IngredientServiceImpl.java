package com.optum.Ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class IngredientServiceImpl implements IngredientService {

    private IngredientRepo ingredientRepo;
    private Ingredient Ingredient;

    @Autowired
    public IngredientServiceImpl(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepo.findAll();
    }


    @Override
    public void saveIngredient(Ingredient Ingredient) {
        ingredientRepo.save(Ingredient);
    }


    /**
     * Returns an Ingredient object based on id argument.
     * <p>
     * @param  id  id of an Ingredient
     * @return      Ingredient object
     */
    @Override
    public Ingredient getIngredientById(long id) {

        Optional<Ingredient> optionalIngredient = ingredientRepo.findById(id);
        if (optionalIngredient.isPresent()) {
            Ingredient Ingredient = optionalIngredient.get();
            return Ingredient;
        }
        throw new IngredientNotFoundException();
    }

    @Override
    public Ingredient getIngredientByName(String name) {
        Ingredient Ingredient = ingredientRepo.findFirstByLastName(name);
        if (Ingredient == null) {
            throw new IngredientNotFoundException();
        }
        return Ingredient;
    }

    @Override
    public void deleteIngredientById(long id) {
        ingredientRepo.deleteById(id);
    }
}