package com.optum.Ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class IngredientController {

    private IngredientService IngredientService;

    public IngredientController() {
    }

    @Autowired
    public IngredientController(IngredientService IngredientService) {
        this.IngredientService = IngredientService;
    }

    @GetMapping("/")
    public String getAllIngredients(Model model) {
        model.addAttribute("listIngredients", IngredientService.getAllIngredients());
        return "index";
    }

    @GetMapping("/showNewIngredientForm")
    public String showNewIngredientForm(Model model) {
        // create model attribute to bind form data
        Ingredient Ingredient = new Ingredient();
        model.addAttribute("Ingredient", Ingredient);
        return "new_Ingredient";
    }

    @PostMapping("/saveIngredient")
    public String saveIngredient(@ModelAttribute("Ingredient") @Valid Ingredient Ingredient,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "new_Ingredient";
        }

        // save Ingredient to database
        IngredientService.saveIngredient(Ingredient);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get Ingredient from the service
        Ingredient Ingredient = IngredientService.getIngredientById(id);

        // set Ingredient as a model attribute to pre-populate the form
        model.addAttribute("Ingredient", Ingredient);
        return "update_Ingredient";
    }

    @GetMapping("/deleteIngredient/{id}")
    public String deleteIngredient(@PathVariable(value = "id") long id) {

        // call delete Ingredient method
        this.IngredientService.deleteIngredientById(id);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }
}

