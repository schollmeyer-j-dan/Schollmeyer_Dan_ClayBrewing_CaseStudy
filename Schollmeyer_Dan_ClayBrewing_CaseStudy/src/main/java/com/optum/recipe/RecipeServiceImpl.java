package com.optum.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepo repo;

    @Autowired
    public RecipeServiceImpl(RecipeRepo repo){ this.repo = repo; }

    @Override
    public List<Recipe> getAllRecipes() {
        return repo.findAll();
    }

    @Override
    public Recipe getRecipeById(long id) {
        return repo.getById(id);
    }

    @Override
    public Recipe getRecipeByName(String name) {
        return repo.findFirstByName(name);
    }
}
