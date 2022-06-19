package com.ecommerce.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import com.ecommerce.jwt.JwtUtil;
@Component
public class SecurityFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtil util;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//read token from auth head
		String token= request.getHeader("Authorization");
		if(token!=null)
		{
			//validation
			String username = util.getUsername(token);
			//usenamr not be empty and security context holder must be null
			if(username != null && SecurityContextHolder.getContext().getAuthentication() == null)
			{
				UserDetails user=userDetailsService.loadUserByUsername(username);
			
			//validate token
			boolean isValid=util.validateToken(token, user.getUsername() );
			
			if(isValid)
			{
				UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(username,user.getPassword(),user.getAuthorities());
				
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				//final object stored in 
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
			}
		}
		filterChain.doFilter(request, response);
		
	}

}
