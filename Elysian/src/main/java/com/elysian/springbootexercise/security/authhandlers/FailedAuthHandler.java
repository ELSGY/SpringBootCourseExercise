package com.elysian.springbootexercise.security.authhandlers;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FailedAuthHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(final HttpServletRequest httpServletRequest,
										final HttpServletResponse httpServletResponse,
										final AuthenticationException e) {
		// perform failed auth operations - ex: increasing the failed password attempts count, etc
	}
}
