package com.steve.academysteveback.token;

public interface JwtProperties {
	String HEADER = "Authorization";
	String TOKEN_PREFIX = "Bearer ";
	String SECRET = "DFK79JD2234AEL12";
	Long EXPIRATION_TIME = 864000000L;
}
