package com.optum.ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepo extends JpaRepository<Ingredient, Long> {
    Ingredient findFirstByName(String name);
    Ingredient findFirstById(long id);
}
