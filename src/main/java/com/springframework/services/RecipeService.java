package com.springframework.services;

import com.springframework.domain.Recipe;

import java.util.Set;

/**
 * Created by Nidhal on 07/06/2019.
 */
public interface RecipeService {

    Set<Recipe> getRecipes();
}
