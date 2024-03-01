package br.com.Comunidades.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${app.jwt.secret}")
	private String jwtSecret;

	@Value("${app.jwt.expiration.ms}")
	private int jwtExpirationMs;
	
	public String generateToken(String username, Integer id, String cargo, String apelido) {
	    SecretKey secretKeySpec = Keys.hmacShaKeyFor(jwtSecret.getBytes());
	    return Jwts.builder()
	            .setSubject(username)
	            .claim("userId", id)
	            .claim("apelido", apelido)
	            .claim("cargo", cargo)
	            .setExpiration(new Date(System.currentTimeMillis() + this.jwtExpirationMs))
	            .signWith(secretKeySpec)
	            .compact();
	}

	public String getUserNameFromJwtToken(String token) {
		SecretKey sKey = Keys.hmacShaKeyFor(jwtSecret.getBytes());
		return Jwts.parserBuilder()
				.setSigningKey(sKey)
				.build()
				.parseClaimsJws(token)
				.getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			SecretKey sKey = Keys.hmacShaKeyFor(jwtSecret.getBytes());
			Jwts.parserBuilder()
				.setSigningKey(sKey)
				.build()
				.parseClaimsJws(authToken)
				.getBody()
				.getSubject();
			return true;
		}catch (JwtException e) {
			logger.error("Token JWT inválido: {}", e.getMessage());
		}
		return false;
	}
}
