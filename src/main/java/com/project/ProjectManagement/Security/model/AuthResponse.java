package com.project.ProjectManagement.Security.model;

public class AuthResponse {
    private String token;
    private String role;
    private String name;
    
    
	public AuthResponse() {
		super();
	}
	public AuthResponse(String token, String role, String name) {
		super();
		this.token = token;
		this.role = role;
		this.name = name;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    
}