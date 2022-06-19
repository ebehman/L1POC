package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.User;
import com.ecommerce.repository.UserDAORepository;
import com.ecommerce.servicerepository.UserServiceRepository;
import com.ecommerce.user.dto.RegesterUserDto;
@Service
public class UserService implements UserServiceRepository , UserDetailsService{
	
	@Autowired
	private UserDAORepository userDaoRepo;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;

	
	
	public UserService(UserDAORepository userDaoRepo, BCryptPasswordEncoder pwdEncoder) {
		super();
		this.userDaoRepo = userDaoRepo;
		this.pwdEncoder = pwdEncoder;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userDaoRepo.findByEmail(username);
		if(user==null)
		{
		throw new UsernameNotFoundException("user not exists");
		}
	
		return new org.springframework.security.core.userdetails.User(
										username,
										user.getPassword(),
										new ArrayList<>());
	}

	public String saveUserDetails(RegesterUserDto userDto) {
		if (userDto.getEmail() == null || userDto.getFname() == null || userDto.getLname() == null
				|| userDto.getPassword() == null) {
			return "please enter the correct user details ";
		} 

		else if (Boolean.TRUE.equals(userDaoRepo.existsByEmail(userDto.getEmail())))// Boolean.TRUE.equals(<boolean
																					// variable>)
		{
			return "The Email is already taken...!!";
		} 
		else {
			User user = new User();
			BeanUtils.copyProperties(userDto, user);
			user.setPassword(pwdEncoder.encode(userDto.getPassword()));
			userDaoRepo.save(user);
			BeanUtils.copyProperties(user, userDto);
			return "User regestered Scuccessfully";
		}
	}
	
	public List<User> getUserDetails()
	{
		return userDaoRepo.findAll();
	}
	
	public User getUserById(Long id)
	{
		
		return userDaoRepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("USER", "Id", id));
	}
	

	@Override
	public User getUserByFname(String fname) {
		
		return userDaoRepo.findByFname(fname);
		
	}
	
	public User getUserByLname(String lname)
	{
		
		return userDaoRepo.findByLname(lname);
	}
	
	public User getUserByEmail(String email)
	{
		return userDaoRepo.findByEmail(email);
	}
	
	public String deleteUser(Long id) {
		userDaoRepo.deleteById(id);
		return "deleted";
		
	}
	//update UserDetails
	
	public String updateUserDetails(RegesterUserDto udto,Long id)
	{
			User exuser=userDaoRepo.findById(id).orElseThrow(()->
			new ResourceNotFoundException("USER", "Id", id));
			exuser.setUserId(id);
			exuser.setEmail(udto.getEmail());
			exuser.setFname(udto.getFname());
			exuser.setLname(udto.getLname()); 
			exuser.setPassword(pwdEncoder.encode(udto.getPassword()));
			userDaoRepo.save(exuser);
			return "user details updated successfully";
			
		}
			
	}

	

