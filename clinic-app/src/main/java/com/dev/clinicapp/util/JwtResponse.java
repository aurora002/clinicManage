package com.dev.clinicapp.util;

public class JwtResponse {

	private final String jwt;
	private final String username;

	public JwtResponse(String jwt, String username) {
		super();
		this.jwt = jwt;
		this.username = username;
	}

	public String getJwt() {
		return this.jwt;
	}
	
	public String getUsername() {
		return this.username;
	}
}
