package com.springframework.bootstrap;

import com.springframework.domain.*;
import com.springframework.repositories.CategoryRepository;
import com.springframework.repositories.RecipeRepository;
import com.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Nidhal on 07/06/2019.
 */

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }


    /*@PostConstruct
    public void postConstructRecipeBootstrap(){
        recipeRepository.saveAll(getRecipes());
    }*/

    private List<Recipe> getRecipes(){

      List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if(!tablespoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if(!tablespoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");

        if(!tablespoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");

        if(!tablespoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        UnitOfMeasure tableSpoonUom =  tablespoonUomOptional.get();
        UnitOfMeasure cupUom =  cupUomOptional.get();
        UnitOfMeasure pinchUom =  pinchUomOptional.get();
        UnitOfMeasure ounceUom =  ounceUomOptional.get();


        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

        Recipe guacRecipe = new Recipe();

        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPreTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("ou want ripe but not over-ripe Hass avocados, which are the standard grocery store variety with slightly bumpy skin. Look for avocados that yield a bit to a gentle squeeze, but avoid using avocados that are mushy or stringy on the inside (yuck!).\n" +
                "\n" +
                "If you have to choose between hard or mushy avocados, choose the hard ones and place them in a paper bag with a couple of bananas. The ethylene gas released by the bananas will ripen them up faster, but you still might have to wait overnight or up to a couple of days.\n" +
                "\n" +
                "If you come home with perfect avocados but won’t be turning them into guac right away, store them in the refrigerator to slow their ripening.");


        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("I’ve discovered that just over 2 teaspoons lime \n" +
                "juice per mashed avocado is the perfect ratio for flavor and browning \n" +
                "prevention. You might need a splash more lime juice if your avocados \n" +
                "are particularly large.");

        guacRecipe.setNotes(guacNotes);
        guacNotes.setRecipe(guacRecipe);

        guacRecipe.getIngredients().add(new Ingredient("recipe avocado",new BigDecimal(10),cupUom));
        guacRecipe.getIngredients().add(new Ingredient("Texture is key",new BigDecimal(14),tableSpoonUom));
        guacRecipe.getIngredients().add(new Ingredient("Skip the tomato and garlic",new BigDecimal(10),pinchUom));
        guacRecipe.getIngredients().add(new Ingredient("Get your lime-to-avocado ratio ",new BigDecimal(10),cupUom));
        guacRecipe.getIngredients().add(new Ingredient("Season sufficiently",new BigDecimal(10),ounceUom));

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);

        recipes.add(guacRecipe);



        Recipe tacosRecipe = new Recipe();

        tacosRecipe.setDescription("Perfect Tacos");
        tacosRecipe.setPreTime(10);
        tacosRecipe.setCookTime(0);
        tacosRecipe.setDifficulty(Difficulty.EASY);
        tacosRecipe.setDirections("ou want ripe but not over-ripe Hass avocados, which are the standard grocery store variety with slightly bumpy skin. Look for avocados that yield a bit to a gentle squeeze, but avoid using avocados that are mushy or stringy on the inside (yuck!).\n" +
                "\n" +
                "If you have to choose between hard or mushy avocados, choose the hard ones and place them in a paper bag with a couple of bananas. The ethylene gas released by the bananas will ripen them up faster, but you still might have to wait overnight or up to a couple of days.\n" +
                "\n" +
                "If you come home with perfect avocados but won’t be turning them into guac right away, store them in the refrigerator to slow their ripening.");


        Notes tacosNotes = new Notes();
        tacosNotes.setRecipeNotes("I’ve discovered that just over 2 teaspoons lime \n" +
                "juice per mashed avocado is the perfect ratio for flavor and browning \n" +
                 "are particularly large.");

        tacosRecipe.setNotes(tacosNotes);
        tacosNotes.setRecipe(tacosRecipe);

        tacosRecipe.getIngredients().add(new Ingredient("recipe avocado",new BigDecimal(10),cupUom));
        tacosRecipe.getIngredients().add(new Ingredient("Texture is key",new BigDecimal(14),tableSpoonUom));
        tacosRecipe.getIngredients().add(new Ingredient("Skip the tomato and garlic",new BigDecimal(10),pinchUom));
        tacosRecipe.getIngredients().add(new Ingredient("Get your lime-to-avocado ratio ",new BigDecimal(10),cupUom));

        tacosRecipe.getCategories().add(americanCategory);

        recipes.add(tacosRecipe);

      return recipes;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }
}
