package com.ecommerce.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private SecurityFilter securityfilter;
	
	@Autowired
	private UserAuthenticationEntryPoint userAuthenticationEntryPoint;
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http
		.csrf().disable()
		.authorizeHttpRequests()
		.antMatchers("/api/regesterUser","/api/userLogin").permitAll()
//		,"/api/updateUserDetails/*","/api/updatePassword/*","/api/deleteUser/*","/api/users","/api/users/*",
//					"/api/fname/*","/api/lname/*","/api/email/*").permitAll()
//		.antMatchers("/saveWatches","/getWatches","/updateWatches/*","/deleteWatches/*","/getWatches/*").permitAll()
//		.antMatchers("/saveLaptop","/getLaptop","/updateLaptop/*","/deleteLaptop/*","/getLaptop/*").permitAll()
//		.antMatchers("/saveMobile","/getMobile","/updateMobile/*","/deleteMobile/*","/getMobile/*").permitAll()
//		.antMatchers("/saveTv","/getTv","/updateTv/*","/deleteTv/*","/getTv/*").permitAll()
//		.antMatchers("/swagger-ui.html","/swagger-ui.html/*").permitAll()
		.anyRequest().authenticated()
		.and()
		.exceptionHandling()
		.authenticationEntryPoint(userAuthenticationEntryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		//request filter for 2nd request onwards
		.and()
		.addFilterBefore(securityfilter, UsernamePasswordAuthenticationFilter.class) ;
	}
	
	@Override
	  public void configure(WebSecurity web) throws Exception {
	    web
	      .ignoring()
	        .mvcMatchers("/swagger-ui.html/**", "/configuration/**", "/swagger-resources/**", "/v2/api-docs", "/webjars/**");
	  }
}
