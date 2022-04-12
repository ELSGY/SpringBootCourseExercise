package com.elysian.springbootexercise.security;

public class Roles {

	public static final String USER_ROLE = "USER_ROLE"; // for GET methods, I considered searching endpoints in online store for example

	public static final String ADMIN_ROLE = "ADMIN_ROLE";

	public static String getUserRole() {
		return USER_ROLE;
	}

	public static String getAdminRole() {
		return ADMIN_ROLE;
	}
}
