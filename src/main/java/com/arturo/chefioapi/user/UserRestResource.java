package com.arturo.chefioapi.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface UserRestResource extends MongoRepository<User, String> {
    
    User findOneByUsernameIgnoreCase(@Param("username") String username);
    
}