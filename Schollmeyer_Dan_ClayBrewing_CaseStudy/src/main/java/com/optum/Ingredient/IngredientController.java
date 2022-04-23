package com.optum.Ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class IngredientController {

    private IngredientService ingredientService;

    public IngredientController() {
    }

    @Autowired
    public IngredientController(IngredientService IngredientService) {
        this.ingredientService = IngredientService;
    }

    @GetMapping("/")
    public String getAllIngredients(Model model) {
        model.addAttribute("listIngredients", ingredientService.getAllIngredients());
        return "InventoryManagerIndex";
    }

    @GetMapping("/createIngredient")
    public String showNewIngredientForm(Model model) {
        Ingredient Ingredient = new Ingredient();
        model.addAttribute("Ingredient", Ingredient);
        return "CreateIngredient";
    }

    @GetMapping("/displayInventory")
    public String displayInventory(Model model){
        model.addAttribute("ingredientsList",ingredientService.getAllIngredients());
        return "DisplayInventory";
    }

    @PostMapping("/saveIngredient")
    public String saveIngredient(@ModelAttribute("Ingredient") @Valid Ingredient ingredient,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_Ingredient";
        }
        ingredientService.saveIngredient(ingredient);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Ingredient Ingredient = ingredientService.getIngredientById(id);
        model.addAttribute("Ingredient", Ingredient);
        return "update_Ingredient";
    }

    @GetMapping("/deleteIngredient/{id}")
    public String deleteIngredient(@PathVariable(value = "id") long id) {
        this.ingredientService.deleteIngredientById(id);
        return "redirect:/";
    }

}

