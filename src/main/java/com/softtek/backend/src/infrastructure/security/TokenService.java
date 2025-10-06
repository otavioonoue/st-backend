package com.softtek.backend.src.infrastructure.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.softtek.backend.src.domain.entity.User;

@Service
public class TokenService {

	@Value("${api.security.registrationtoken.secret}")
    private String registrationSecret;
    
    @Value("${api.security.token.secret}")
    private String secret;
    
    @Value("${api.security.token.expiresAt}")
    private long expiresAt;

	public String generateRegisterToken(User user) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(registrationSecret);
			String token = JWT.create()
			    .withIssuer("api")
				.withSubject(user.getUsername())
			    .withExpiresAt(generateRegisterTokenExpirationDate())
			    .sign(algorithm);
		    return token;
		} catch(JWTCreationException e) {
		    throw new RuntimeException("Error generating token", e);
		}
	}

	public String validateRegisterToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(registrationSecret);
			return JWT.require(algorithm)
				.withIssuer("api")
				.build()
				.verify(token)
				.getSubject();
		} catch (JWTVerificationException e) {
			return "";
		}
	}
    
	public String generateToken(User user) {
	    try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			String token = JWT.create()
			    .withIssuer("api")
			    .withSubject(user.getUsername())
			    .withExpiresAt(generateExpirationDate())
			    .sign(algorithm);
		    return token;
		} catch(JWTCreationException e) {
		    throw new RuntimeException("Error generating token", e);
		}
	}
	
	public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm)
				.withIssuer("api")
				.build()
				.verify(token)
				.getSubject();
		} catch (JWTVerificationException e) {
			return "";
		}
	}
	
	private Instant generateExpirationDate() {
	    return LocalDateTime.now().plusHours(expiresAt).toInstant(ZoneOffset.of("-03:00"));
	} 
	
	private Instant generateRegisterTokenExpirationDate() {
	    return LocalDateTime.now().plusMinutes(30).toInstant(ZoneOffset.of("-03:00"));
	}  

	
}