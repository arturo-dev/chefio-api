package com.arturo.chefioapi.recipe;

import java.text.Normalizer;
import java.util.Date;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.arturo.chefioapi.recipe.model.Recipe;

@Component
@RepositoryEventHandler(Recipe.class)
public class RecipeEventHandler {

	@HandleBeforeCreate
    public void handleBeforeCreate(Recipe recipe) {
        recipe.setCreationDate(new Date());
        recipe.getIngredients().forEach(ingredient -> {
        	ingredient.setItem(Normalizer
	           .normalize(ingredient.getItem(), Normalizer.Form.NFD)
	           .replaceAll("[^\\p{ASCII}]", "").toLowerCase()
	          );
        });
    }
	
}
