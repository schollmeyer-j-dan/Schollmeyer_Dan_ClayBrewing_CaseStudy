package com.optum.recipe;

import com.optum.ingredient.Ingredient;
import com.optum.ingredient.IngredientService;
import com.optum.quantity_type.QuantityType;
import com.optum.quantity_type.QuantityTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RecipeController {

    private IngredientService ingredientService;
    private QuantityTypeService quantityTypeService;
    private RecipeService recipeService;
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    public RecipeController() {
    }

    @Autowired
    public RecipeController(RecipeService recipeService, IngredientService ingredientService, QuantityTypeService quantityTypeService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.quantityTypeService = quantityTypeService;
    }


    @GetMapping("/displayRecipes")
    public String displayRecipes(Model model){
        model.addAttribute("recipesList",recipeService.getAllRecipes());
        LOGGER.info("Recipe list retrieved for view.");
        return "DisplayRecipes";
    }

/*
    @GetMapping("/createIngredient")
    public String showNewIngredientForm(Model model) {
        Ingredient ingredient = new Ingredient();
        List<QuantityType> typeList = quantityTypeService.getAllQuantityTypes();
        model.addAttribute("ingredient", ingredient);
        model.addAttribute("typeList",typeList);

        return "CreateIngredient";
    }

    @PostMapping("/createIngredient")
    public String createIngredient(@ModelAttribute("Ingredient") @Valid Ingredient ingredient,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "CreateIngredient";
        }

        ingredientService.saveIngredient(ingredient);
        LOGGER.info("Ingredient saved: " + ingredient.getName());
        return "redirect:/displayInventory";
    }

    @GetMapping("/updateIngredient/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Ingredient ingredient = ingredientService.getIngredientById(id);
        List<QuantityType> typeList = quantityTypeService.getAllQuantityTypes();

        model.addAttribute("ingredient", ingredient);
        model.addAttribute("typeList",typeList);

        return "UpdateIngredient";
    }

    @PostMapping("/updateIngredient")
    public String updateIngredient(@ModelAttribute("Ingredient") @Valid Ingredient ingredient,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "UpdateIngredient";
        }

        ingredientService.saveIngredient(ingredient);
        return "redirect:/displayInventory";
    }

    @GetMapping("/deleteIngredient/{id}")
    public String deleteIngredient(@PathVariable(value = "id") long id,Model model) {
        this.ingredientService.deleteIngredientById(id);
        model.addAttribute("ingredientsList",ingredientService.getAllIngredients());
        return "redirect:/displayInventory";
    }
*/
}

