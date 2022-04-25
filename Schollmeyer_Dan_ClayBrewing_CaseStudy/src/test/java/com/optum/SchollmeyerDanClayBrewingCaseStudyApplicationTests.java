package com.optum;

import com.optum.Ingredient.Ingredient;
import com.optum.Ingredient.IngredientRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class SchollmeyerDanClayBrewingCaseStudyApplicationTests {

	@Autowired
	private IngredientRepo ingredientRepo;

/*	@Test
	void contextLoads() {

	}*/


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
