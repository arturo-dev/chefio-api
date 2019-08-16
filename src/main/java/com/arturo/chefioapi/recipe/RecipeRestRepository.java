package com.arturo.chefioapi.recipe;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.arturo.chefioapi.recipe.model.Recipe;

@RestResource
public interface RecipeRestRepository extends MongoRepository<Recipe, String> {

}
