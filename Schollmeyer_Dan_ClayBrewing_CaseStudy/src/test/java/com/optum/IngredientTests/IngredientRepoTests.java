package com.optum.IngredientTests;

import com.optum.ingredient.Ingredient;
import com.optum.ingredient.IngredientRepo;
import com.optum.quantity_type.QuantityType;
import com.optum.quantity_type.QuantityTypeRepo;
import com.optum.quantity_type.QuantityTypeService;
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

	@Autowired
	private QuantityTypeRepo quantityTypeRepo;

	@BeforeEach
	void setUp(){
		ingredientRepo.deleteAll();
		quantityTypeRepo.deleteAll();
		QuantityType type = new QuantityType();
		type.setType("Pounds");
		quantityTypeRepo.save(type);
	}


	@Transactional
	@Test
	public void findByName_should_return_ingredient_given_valid_ingredient() throws Exception {
		QuantityType type = quantityTypeRepo.findFirstByType("Pounds");
		Ingredient expectedIngredient = new Ingredient("Dry Wheat Malt","",type,4);
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
