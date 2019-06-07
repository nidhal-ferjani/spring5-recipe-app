package com.springframework.controllers;

import com.springframework.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Nidhal on 06/06/2019.
 */

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

     @RequestMapping({"", "/", "/index"})
    public String getIndex(Model model){

     /*   Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Cup");

        System.out.println("Cat id is : " + categoryOptional.get().getId());
        System.out.println("UOM id is : " + unitOfMeasureOptional.get().getId());*/

       /* System.out.println("=============================================================================");

        for(Recipe recipe : recipeService.getRecipes()){
            System.out.println("Recipe : " + recipe);
            System.out.println("=============================================================================");
        }*/
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
