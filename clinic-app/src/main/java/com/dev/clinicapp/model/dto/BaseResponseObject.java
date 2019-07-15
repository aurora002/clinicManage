package com.dev.clinicapp.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseResponseObject {

	@JsonProperty("message")
	private String message = "";

	@JsonProperty("id")
	private Long id;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
