package com.arturo.chefioapi.recipe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.arturo.chefioapi.recipe.model.Recipe;

@RestResource
public interface RecipeRestRepository extends MongoRepository<Recipe, String> {
	
	@Query(value = "{'title': { $regex : ?0, $options: 'i' } }")
	Page<Recipe> findByTitle(@Param("param0") String title, Pageable page);
	
	@Query(value = "{ $where: "
			+ "'this.ingredients.length > 0 "
			+ "&& this.ingredients.filter(ing => { "
				+ "const list = ?0 || []; "
				+ "return list.filter(listItem => new RegExp(listItem).test(ing.item.toLowerCase()) ).length === 1"
			+ "}).length == this.ingredients.length' }")
	Page<Recipe> findByIngredients(@Param("param0") String[] ingredients, Pageable page);
	
}
