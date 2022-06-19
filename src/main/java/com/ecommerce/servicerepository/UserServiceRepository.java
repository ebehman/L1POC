package com.ecommerce.servicerepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.model.User;
import com.ecommerce.user.dto.RegesterUserDto;

@Repository
public interface UserServiceRepository {
	//SaveUserDetails
	String saveUserDetails(RegesterUserDto user);
	
	//GetAll User Details
	List<User> getUserDetails();
	
	//Get User Details By Id
	User getUserById(Long id);
	
	//Get user details by First name
	User getUserByFname(String fname);
	
	//Get user details by last name
	User getUserByLname(String lname);
	
	//Get user details by email
	User getUserByEmail(String email);
	
	//UpdateUserdetails
	String updateUserDetails(RegesterUserDto user,Long id);
	
	
	//delete User
	String deleteUser(Long id);
	
}
