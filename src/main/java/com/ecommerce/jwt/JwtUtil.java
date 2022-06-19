package com.ecommerce.jwt;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	@Value("${app.secret}")
	
	private String secret;
	
	//generating token
	public String generateToken(String subject )//subject is username
	{
		return Jwts.builder()
				.setSubject(subject)
				.setIssuer("amrutha")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(15)))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}
	
	//Reading token data --> read claims
	public Claims getClaims(String token)
	{
		return Jwts.parser().setSigningKey(secret.getBytes())
				.parseClaimsJws(token).getBody();
	}
	
	//Expiration Date
	public Date getExpDate(String token)
	{
		return getClaims(token).getExpiration();
	}
	
	//read username
	public String getUsername(String token)
	{
		return getClaims(token).getSubject();
	}
	
	//validate exp date
	public boolean isTokenExp(String token)
	{
		Date expDate=getExpDate(token);
		return expDate.before(new Date(System.currentTimeMillis()));
	}
	//validate token
	public boolean validateToken(String token,String username)
	{
		String tokenUserName=getUsername(token);
		return (username.equals(tokenUserName) && !isTokenExp(token));
	}
}
