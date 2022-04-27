package com.optum.IngredientTests;

import com.optum.ingredient.Ingredient;
import com.optum.ingredient.IngredientRepo;
import com.optum.ingredient.IngredientServiceImpl;
import com.optum.quantity_type.QuantityType;
import com.optum.quantity_type.QuantityTypeRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

@SpringBootTest
public class IngredientServiceTests {

    @Autowired
    private IngredientServiceImpl ingredientService;

    @Autowired
    private IngredientRepo ingredientRepo;
    @Autowired
    private QuantityTypeRepo quantityTypeRepo;

    @BeforeEach
    public void setUp(){
        ingredientRepo.deleteAll();
        quantityTypeRepo.deleteAll();
        QuantityType type = new QuantityType();
        type.setType("Pounds");
        quantityTypeRepo.save(type);
        Ingredient ingredient = new Ingredient();
        ingredient.setName("Test");
        ingredient.setDescription("A test ingredient");
        ingredient.setQuantityType(quantityTypeRepo.findFirstByType("Pounds"));
        ingredient.setQuantity(10);

        ingredientRepo.save(ingredient);

        this.ingredientService=new IngredientServiceImpl(ingredientRepo);
    }

    @Test
    public void getAllIngredientsReturnsListOfIngredientsIfNotEmpty(){
        List<Ingredient> ingredientList = ingredientService.getAllIngredients();

        assertThat(ingredientList).asList().hasSize(1);
    }

    @Test
    public void saveIngredientPersistsIngredientToDb(){
        Ingredient testIngredient = new Ingredient();
        testIngredient.setName("test2");
        testIngredient.setQuantityType(quantityTypeRepo.findFirstByType("Pounds"));
        ingredientRepo.save(testIngredient);

        assertThat(testIngredient).isEqualTo(ingredientRepo.findFirstByName("test2"));
    }

    @Test
    public void getIngredientByIdReturnsIngredientGivenValidId(){
        Ingredient testIngredient = ingredientService.getIngredientById(
                ingredientRepo.findFirstByName("Test").getId());
        assertThat(testIngredient).isNotNull();
    }

    @Test
    public void deleteIngredientByIdReturnsNull() {
        ingredientService.deleteIngredientById(ingredientRepo.findFirstByName("Test").getId());
        assertThat(ingredientRepo.findFirstByName("Test")).isNull();
    }
}
