package com.arturo.chefioapi.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UserRestResource userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.arturo.chefioapi.user.User user = userRepository.findOneByUsernameIgnoreCase(username);
        UserDetails loged = null;

        if (user != null) {
            loged = new User(
                    user.getId(), 
                    user.getPassword(), 
                    user.getEnabled(),
                    user.getAccountNonExpired(),
                    user.getCredentialsNonExpired(),
                    user.getAccountNonLocked(),
                    user.getAuthorities());
        } else {
        	loged = new User("NOT_AUTH", "NOT_AUTH", new ArrayList<GrantedAuthority>());
        }

        return loged;
    }

}