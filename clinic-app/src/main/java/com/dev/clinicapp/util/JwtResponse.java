package com.dev.clinicapp.util;

public class JwtResponse {

	private final String jwt;

	public JwtResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}
	
	
}
