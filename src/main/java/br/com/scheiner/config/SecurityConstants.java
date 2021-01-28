package br.com.scheiner.config;

public class SecurityConstants {
	public static final String SECRET = "SECRET_KEY";
	public static final long EXPIRATION_TIME = 900_000; // 15 min
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String USER_API = "/api/user";
	public static final String USER_LOGIN = "/auth";
	public static final String HEALTH_CHECK = "/actuator/*";

}
