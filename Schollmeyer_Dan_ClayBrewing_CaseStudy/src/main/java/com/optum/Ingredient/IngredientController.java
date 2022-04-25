package com.optum.Ingredient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class IngredientController {

    private IngredientService ingredientService;
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    public IngredientController() {
    }

    @Autowired
    public IngredientController(IngredientService IngredientService) {
        this.ingredientService = IngredientService;
    }

    @GetMapping("/")
    public String getAllIngredients(Model model) {
        Ingredient ingredient = new Ingredient();
        model.addAttribute("ingredient", ingredient);
        return "InventoryManagerIndex";
    }

    @GetMapping("/displayInventory")
    public String displayInventory(Model model){
        model.addAttribute("ingredientsList",ingredientService.getAllIngredients());
        LOGGER.info("Ingredient list retrieved for view.");
        return "DisplayInventory";
    }

    @GetMapping("/createIngredient")
    public String showNewIngredientForm(Model model) {
        Ingredient ingredient = new Ingredient();

        model.addAttribute("ingredient", ingredient);

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
        model.addAttribute("ingredient", ingredient);
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

}

