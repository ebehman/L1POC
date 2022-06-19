package com.ecommerce.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.User;

public interface UserDAORepository extends JpaRepository<User, Long> {
	
 
	Boolean existsByEmail(String email);
		
	User findByEmail(String email);
	
	User findByFname(String fname);
	
	User findByLname(String lname);
	
	User findByUserId(Long userId);
	 
}
