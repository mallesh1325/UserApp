package org.users.dto;

public class AuthResponceDto {

	private String token;

	public String getToken() {
		return token;
	}

	public AuthResponceDto(String token) {
		this.token = token;
	}
}
