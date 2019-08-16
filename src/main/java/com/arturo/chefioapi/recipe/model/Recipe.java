package com.arturo.chefioapi.recipe.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

public class Recipe {

	@Id
	private String id;
	
	private String title;
	private Integer duration;
	private String img;
	private ArrayList<Ingredient> ingredients = new ArrayList<>();
	private ArrayList<Step> steps = new ArrayList<>();
	
}
