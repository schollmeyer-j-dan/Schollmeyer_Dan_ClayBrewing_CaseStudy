package com.optum.recipe;

import com.optum.ingredient.Ingredient;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    private String name;
    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="recipes_ingredients",
        joinColumns = {
            @JoinColumn(name="recipe_id",referencedColumnName = "id",
            nullable = false,updatable = false)},
        inverseJoinColumns = {
            @JoinColumn(name="ingredient_id",referencedColumnName = "id",
            nullable = false, updatable = false)})
    private List<Ingredient> ingredients;
    public List<Ingredient> getIngredients(){return ingredients;}
    public void setIngredients(List<Ingredient> ingredients){this.ingredients = ingredients;}

    //todo: add category (wheat/sour/hefe etc)
}
