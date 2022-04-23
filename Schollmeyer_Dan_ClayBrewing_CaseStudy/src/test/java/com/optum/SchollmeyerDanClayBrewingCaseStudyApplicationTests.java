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
		System.out.println(ingredientRepo.findAll());
	}

	@Transactional
	@Test
	public void findByName_should_return_ingredient_given_valid_ingredient() throws Exception {
		Ingredient expectedIngredient = new Ingredient();
		expectedIngredient.setName("Dry Wheat Malt");
		expectedIngredient.setDescription("");
		expectedIngredient.setQuantityType("Pounds");
		expectedIngredient.setQuantity(4);
		//Ingredient expectedIngredient = new Ingredient( 1, "Dry Wheat Malt", "","Pounds", 4);
		ingredientRepo.save(expectedIngredient);
		Ingredient actualIngredient = ingredientRepo.findFirstByName("Dry Wheat Malt");
		System.out.println(expectedIngredient.getId());
		System.out.println(actualIngredient.getId());
		System.out.println(expectedIngredient.getName());
		System.out.println(actualIngredient.getName());
		System.out.println(expectedIngredient.getDescription());
		System.out.println(actualIngredient.getDescription());
		System.out.println(expectedIngredient.getQuantity());
		System.out.println(actualIngredient.getQuantity());
		System.out.println(expectedIngredient.getQuantityType());
		System.out.println(actualIngredient.getQuantityType());
		assertThat(expectedIngredient).isEqualTo(actualIngredient);
	}

	@Test
	public void findByName_should_return_null_given_invalid_car() throws Exception {
		Ingredient ingredient = ingredientRepo.findFirstByName("asdf");
		assertThat(ingredient).isEqualTo(null);
	}
}
