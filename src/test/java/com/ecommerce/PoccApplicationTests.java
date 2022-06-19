package com.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecommerce.controller.UserController;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.User;
import com.ecommerce.service.UserService;
import com.ecommerce.user.dto.RegesterUserDto;
import com.ecommerce.user.dto.UserDto;

@TestMethodOrder(OrderAnnotation.class)
@RunWith(SpringRunner.class)
@SpringBootTest
class PoccApplicationTests {

	@Autowired
	private UserService userService;
	

	@Autowired
	private UserController userController;
	
	RegesterUserDto uDto = new RegesterUserDto();

	User u = new User();

	{
		u.setEmail("jessie@gmail.com");
		u.setFname("jessie");
		u.setLname("gracii");
		u.setPassword("graci123");
	}
	 
	{
		uDto.setUserId(1L);
		uDto.setEmail("jessie@gmail.com");
		uDto.setFname("jessie");
		uDto.setLname("gracii");
		uDto.setPassword("gracii");
		uDto.getEmail();
		uDto.getFname();
		uDto.getLname();

	}
	
	RegesterUserDto update = new RegesterUserDto();
	UserDto dto=new UserDto();
	{
		dto.setEmail("jessie@gmail.com");
		dto.setPassword("gracii");
	}
	
	{
		update.setUserId(1L);
		update.setEmail("abc@gmail.com");
		update.setFname("abc");
		update.setLname("xyz");
		update.setPassword("abcxyz");
		update.getEmail();
		update.getFname();
		update.getLname();
		update.getPassword();
		update.getUserId();
	}
		
	 
	@Order(1)
	@Test
	void saveUserDetailsTest() {
		
		assertEquals("User regestered Scuccessfully", userService.saveUserDetails(uDto));
	}
	
	@Order(2)
	@Test
	void saveUserDetailsTestFail1() {
		assertEquals("please enter the correct user details ",userService.saveUserDetails(new RegesterUserDto(null,null,null,null,null)));
		
	}
	
	@Order(3)
	@Test
	void saveUserDetailsTestFail2() {
		assertEquals("The Email is already taken...!!",
				userService.saveUserDetails(new RegesterUserDto(1L,  "jessie@gmail.com","jessie", "gracii", "e")));

	}
	
	@Order(4)
	@Test
	void loadUserByUsernameTest() {
		assertEquals("jessie@gmail.com", userService.loadUserByUsername("jessie@gmail.com").getUsername());
	}

	@Order(5)
	@Test
	void loadUserByUsernameTestFail() {
		//User u = new User(18L, "ab", "bc", "sds", "de");
		assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername("ab").getUsername(),
				"user not exists");
	}

	@Order(6)
	@Test
	void getUserDetailsTest() {
		assertEquals(1, userService.getUserDetails().size());

	}

	@Order(7)
	@Test
	void getUserByIdTest() {
		Long id = 1L;
		assertEquals("jessie", userService.getUserById(id).getFname());
	}

	@Order(8)

	@Test
	void getUserByFnameTest() {
		String fname = "jessie";
		assertEquals("jessie", userService.getUserByFname(fname).getFname());
	}

	@Order(9)

	@Test
	void getUserByLnameTest() {
		String lname = "gracii";
		assertEquals("gracii", userService.getUserByLname(lname).getLname());
	}

	@Order(10)

	@Test
	void getUserByEmailTest() {
		String email = "jessie@gmail.com";
		Assert.assertEquals(email, userService.getUserByEmail(email).getEmail());
	}

	

	@Order(11)

	@Test
	void findByIdException() {
		Long id = 5L;
		assertThrows(ResourceNotFoundException.class, () -> userService.getUserById( id),
				"user not found with userId : " + id + "");
	}

	@Order(12)

	@Test
	void updateUserDetailsTestFail() {
		Long id = 12L;
		assertThrows(ResourceNotFoundException.class, () -> userService.updateUserDetails(uDto, id),
				"user not found with userId : " + id + "");
	}	
	
	@Order(13)

	@Test
	void updateUserDetailsTestPass() {
		Long id = 1L;
		assertEquals("user details updated successfully", userService.updateUserDetails(update, id));
	}
	 
	
	
	@Order(14)
	@Test
	void deleteUserTest() {
		Long id = 1L;
		assertEquals("deleted",userService.deleteUser(id));
	}
	
	@Order(15)
	@Test
	void saveUSerDEtailsTest()
	{
		assertEquals(HttpStatus.CREATED,userController.saveUserDetailss(uDto).getStatusCode());
	}
	
	@Order(16)
	@Test
	void userLoginTest()
	{
		assertEquals(HttpStatus.OK, userController.userLogin(dto).getStatusCode());
	}
	@Order(17)
	@Test
	void userLoginFail()
	{
		UserDto u=new UserDto();
		u.setEmail("abc@gmail.com");
		u.setPassword("abc");
		assertThrows(BadCredentialsException.class, () -> userController.userLogin(u),
				"Bad Credentials");
		//assertEquals(HttpServletResponse.SC_UNAUTHORIZED, userController.userLogin(u).getStatusCode());
	}
	
	@Order(17)
	@Test
	void getAllUsersTest()
	{
		assertEquals(1, userController.getAllUsers().size());
	}
	
	@Order(18)
	@Test
	void getByIdTest()
	{
		Long id=2L;
		assertEquals(HttpStatus.OK, userController.getById(id).getStatusCode());
	}
	@Order(18)
	@Test
	void getByFnameTest()
	{
		String fname="jessie";
		assertEquals(HttpStatus.OK, userController.getByFname(fname).getStatusCode());
	}
	@Test
	void getByLnameTest()
	{
		String lname="gracii";
		assertEquals(HttpStatus.OK, userController.getByLname(lname).getStatusCode());
	}
	@Order(20)
	@Test
	void getByEmailTest()
	{
		String email="jessie@gmail.com";
		assertEquals(HttpStatus.OK, userController.getByEmail(email).getStatusCode());
	}
	
	
	@Order(21)
	@Test
	void updateUserDetailsTest() {
		Long id = 2L;
		
		assertEquals("user details updated successfully", userController.updateUserDetails(update, id).getBody());
	}
	
	@Order(22)
	@Test
	void deleteUserDetailsTest()
	{
		Long id = 2L;
		assertEquals("user deleted successfully",userController.deleteUserDetails(id).getBody());
	}
	

	
}
