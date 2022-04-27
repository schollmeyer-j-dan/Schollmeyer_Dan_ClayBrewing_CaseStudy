package com.optum.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientRESTController {

    private IngredientService service;
    private IngredientRepo repo;

    @Autowired
    public IngredientRESTController(IngredientService ingredientService) {
        this.service = ingredientService;
    }


    @GetMapping("/ingredients")
    public List<Ingredient> getAllMonsters() {
        return service.getAllIngredients();
    }

    @PostMapping("/ingredients")
    public Ingredient newIngredient(@RequestBody Ingredient ingredient) {
        service.saveIngredient(ingredient);
        return ingredient;
    }

    @GetMapping("/ingredients/{id}")
    public Ingredient getIngredientById(@PathVariable Long id) {
        return repo.findById(id).get();
    }

    @PutMapping("/ingredients/{id}")
    public Ingredient updateIngredient(@RequestBody Ingredient ingredient, @PathVariable Long id) {
        return repo.findById(id).map(ingr -> {
            ingredient.setName(ingredient.getName());
            ingredient.setDescription(ingredient.getDescription());
            ingredient.setQuantityType(ingredient.getQuantityType());
            ingredient.setQuantity(ingredient.getQuantity());
            return repo.save(ingredient);
        }).orElseGet(() -> {
            ingredient.setId(id);
            return repo.save(ingredient);
        });
    }

    @DeleteMapping("/ingredients/{id}")
    void deleteMonster(@PathVariable Long id) {
        repo.deleteById(id);
    }
}