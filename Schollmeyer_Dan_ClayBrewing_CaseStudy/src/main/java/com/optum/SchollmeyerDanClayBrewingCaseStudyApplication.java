package com.optum;

import com.optum.ingredient.Ingredient;
import com.optum.quantity_type.QuantityType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.geom.QuadCurve2D;

@SpringBootApplication
public class SchollmeyerDanClayBrewingCaseStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchollmeyerDanClayBrewingCaseStudyApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
	return args -> System.out.println("Clay Brewing has Started!");
	}
}
