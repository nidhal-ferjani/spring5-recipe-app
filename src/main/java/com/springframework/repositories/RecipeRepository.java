package com.springframework.repositories;

import com.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nidhal on 06/06/2019.
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
