package com.arturo.chefioapi.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.arturo.chefioapi.recipe.model.Recipe;
import com.arturo.chefioapi.user.User;

@Configuration
public class RestDataConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Recipe.class, User.class);
    }

}