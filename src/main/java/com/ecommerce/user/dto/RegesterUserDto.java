package com.ecommerce.user.dto;



public class RegesterUserDto {
	
	private Long userId;

	private String email;

	private String fname;

	private String lname;

	private String password;
	

	public RegesterUserDto() {
		super();
	}

	public RegesterUserDto(Long userId, String email, String fname, String lname, String password) {
		super();
		this.userId = userId;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
