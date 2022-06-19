package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.jwt.JwtUtil;
import com.ecommerce.model.User;
import com.ecommerce.servicerepository.UserServiceRepository;
import com.ecommerce.user.dto.RegesterUserDto;
import com.ecommerce.user.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserServiceRepository userServiceRepo;
	
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
		
	
	public UserController(UserServiceRepository userServiceRepo, JwtUtil jwtUtil,
			AuthenticationManager authenticationManager) {
		super();
		this.userServiceRepo = userServiceRepo;
		this.jwtUtil = jwtUtil;
		this.authenticationManager = authenticationManager;
	}


	@PostMapping("/regesterUser")
	public ResponseEntity<String> saveUserDetailss(@RequestBody RegesterUserDto user)
	{
		return new ResponseEntity<>(userServiceRepo.saveUserDetails(user),HttpStatus.CREATED);
		
	}
	
	
	//login using jwt
		@PostMapping("/userLogin")
		public ResponseEntity<String> userLogin(@RequestBody UserDto userDto) throws UsernameNotFoundException
		{
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));

			String token=jwtUtil.generateToken(userDto.getEmail());
			return new ResponseEntity<>("token: "+token+"\n\nmessage: User Logged in successfully",HttpStatus.OK);
			
		}
		

	//get all users
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return userServiceRepo.getUserDetails();
	}
	
	
	//get user by id
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id)
	{
		
		return new ResponseEntity<>(userServiceRepo.getUserById(id), HttpStatus.OK);
	}
	
	
	//get User By fname
	@GetMapping("/fname/{fname}")
	public ResponseEntity<User> getByFname(@PathVariable String fname)
	{
		return new ResponseEntity<>(userServiceRepo.getUserByFname(fname), HttpStatus.OK);
	}
	
	
	//get User By lname
	@GetMapping("/lname/{lname}")
	public ResponseEntity<User> getByLname(@PathVariable String lname)
	{
		return new ResponseEntity<>(userServiceRepo.getUserByLname(lname),HttpStatus.OK);
	}
	
	
	//get User By email
	@GetMapping("/email/{email}")
	public ResponseEntity<User> getByEmail(@PathVariable String email)
	{
		return new ResponseEntity<>(userServiceRepo.getUserByEmail(email),HttpStatus.OK);
	}

	
	//delete user
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUserDetails(@PathVariable Long id)
	{
		userServiceRepo.deleteUser(id);
		return new ResponseEntity<>("user deleted successfully",HttpStatus.MOVED_PERMANENTLY);
	}
	
	//update userDetails
	@PutMapping("/updateUserDetails/{id}")
	public ResponseEntity<String> updateUserDetails(@RequestBody RegesterUserDto userDto,@PathVariable Long id)
	{
			
			return new ResponseEntity<>(userServiceRepo.updateUserDetails(userDto, id),HttpStatus.OK);
		
	}
	
	
}
