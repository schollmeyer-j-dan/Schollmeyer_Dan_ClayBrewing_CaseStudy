package com.optum.IngredientTests;

import com.optum.Ingredient.Ingredient;
import com.optum.Ingredient.IngredientRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class IngredientRepoTests {

	@Autowired
	private IngredientRepo ingredientRepo;

	@BeforeEach
	void setUp(){
		ingredientRepo.deleteAll();
	}


	@Transactional
	@Test
	public void findByName_should_return_ingredient_given_valid_ingredient() throws Exception {
		Ingredient expectedIngredient = new Ingredient();
		expectedIngredient.setName("Dry Wheat Malt");
		expectedIngredient.setDescription("");
		expectedIngredient.setQuantityType("Pounds");
		expectedIngredient.setQuantity(4);
		ingredientRepo.save(expectedIngredient);
		Ingredient actualIngredient = ingredientRepo.findFirstByName("Dry Wheat Malt");

		assertThat(expectedIngredient).isEqualTo(actualIngredient);
	}

	@Test
	public void findByName_should_return_null_given_invalid_car() throws Exception {
		Ingredient ingredient = ingredientRepo.findFirstByName("asdf");
		assertThat(ingredient).isEqualTo(null);
	}
}
