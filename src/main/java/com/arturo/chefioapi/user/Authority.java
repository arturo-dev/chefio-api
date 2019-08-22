package com.arturo.chefioapi.user;

import org.springframework.security.core.GrantedAuthority;


public class Authority implements GrantedAuthority {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String role;

    public Authority() {}

    public Authority(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return getRole();
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}