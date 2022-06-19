/*
 * package com.ecommerce;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.mockito.Mockito.times; import static org.mockito.Mockito.verify; import
 * static org.mockito.Mockito.when;
 * 
 * import java.util.ArrayList; import java.util.List; import
 * org.junit.jupiter.api.Test; import org.junit.jupiter.api.TestMethodOrder;
 * import org.junit.jupiter.api.MethodOrderer.OrderAnnotation; import
 * org.junit.jupiter.api.Order; import org.junit.runner.RunWith; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.ecommerce.controller.UserController; import
 * com.ecommerce.jwt.JwtUtil; import com.ecommerce.model.User; import
 * com.ecommerce.service.UserService; import
 * com.ecommerce.user.dto.RegesterUserDto; import
 * com.ecommerce.user.dto.UserDto;
 * 
 * @TestMethodOrder(OrderAnnotation.class)
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest(classes= {UserControllerTest.class}) class UserControllerTest
 * {
 * 
 * @Autowired private UserController userController;
 * 
 * 
 * RegesterUserDto uDto = new RegesterUserDto(); User user=new User( 1L,"ram",
 * "charan", "ram@gmail.com", "ram");
 * 
 * 
 * UserDto dto=new UserDto(); { dto.setEmail("jessie@gmail.com");
 * dto.setPassword("jessie"); }
 * 
 * { user.setUserId(1L); user.setEmail("abc@gmail.com"); user.setFname("abc");
 * user.setLname("xyz"); user.setPassword("abcxyz"); user.getEmail();
 * user.getFname(); user.getLname(); user.getPassword(); user.getUserId(); } {
 * //uDto.setUserId(1L); uDto.setEmail("jessie@gmail.com");
 * uDto.setFname("jessie"); uDto.setLname("gracii");
 * uDto.setPassword("graci123"); uDto.getUserId(); }
 * 
 * @Order(1)
 * 
 * @Test void userLoginTest() { assertEquals(HttpStatus.OK,
 * userController.userLogin(dto).getStatusCode()); }
 * 
 * @Order(2)
 * 
 * @Test void getAllUsersTest() { assertEquals(3,
 * userController.getAllUsers().size()); }
 * 
 * @Order(3)
 * 
 * @Test void getByIdTest() { Long id=1L; User user=new User( 1L,"jessie",
 * "gracii", "jessie@gmail.com", "jessie"); assertEquals(user,
 * userController.getById(id).getBody()); }
 * 
 * @Test void getByFnameTest() { String fname="jessie"; User user=new User(
 * 1L,"jessie", "gracii", "jessie@gmail.com", "jessie"); assertEquals(user,
 * userController.getByFname(fname).getBody()); }
 * 
 * @Test void getByLnameTest() { String lname="gracii"; User user=new User(
 * 1L,"jessie", "gracii", "jessie@gmail.com", "jessie"); assertEquals(user,
 * userController.getByLname(lname).getBody()); }
 * 
 * @Test void getByEmailTest() { String email="jessie@gmail.com"; User user=new
 * User( 1L,"jessie", "gracii", "jessie@gmail.com", "jessie");
 * assertEquals(user, userController.getByEmail(email).getBody()); }
 * 
 * 
 * 
 * @Test void updateUserDetailsTest() { Long id = 4L;
 * 
 * assertEquals("user details updated successfully",
 * userController.updateUserDetails(uDto, id).getBody()); }
 * 
 * @Test void saveUSerDetailsTest() {
 * assertEquals(HttpStatus.CREATED,userController.saveUserDetailss(uDto).
 * getStatusCode()); }
 * 
 * @Test void deleteUserDetailsTest() { Long id = 4L; verify(userController,
 * times(1)).deleteUserDetails(id); }
 * 
 * 
 * 
 * }
 */