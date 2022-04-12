package com.elysian.springbootexercise.security;

import com.elysian.springbootexercise.security.authhandlers.FailedAuthHandler;
import com.elysian.springbootexercise.security.authhandlers.PostLogoutHandler;
import com.elysian.springbootexercise.security.authhandlers.SuccessfulAuthHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.RememberMeConfigurer;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.SimpleRedirectInvalidSessionStrategy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@SuppressWarnings("unused")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user")
			.authorities(Roles.USER_ROLE)
			.roles(Roles.USER_ROLE)
			.password("$2a$10$4xnpk2a5jLr1mf6VWle6Vuv4q7DBsW2rqQcg6N1Ms/y4g98Ry4D4C")
			.and()
			.withUser("admin")
			.authorities(Roles.ADMIN_ROLE)
			.password("$2a$10$4xnpk2a5jLr1mf6VWle6Vuv4q7DBsW2rqQcg6N1Ms/y4g98Ry4D4C");
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/static/**").permitAll()
			.antMatchers(HttpMethod.GET, "/product").hasRole(Roles.USER_ROLE)
			.antMatchers(HttpMethod.POST, "/product").hasAuthority(Roles.USER_ROLE)
			.anyRequest().fullyAuthenticated();

		// registering the post auth handlers
		// they are registered as beans in order to be able to inject other dependencies in them (if needed)
		http.formLogin()
			.successHandler(successfulAuthHandler())
			.failureHandler(failedAuthHandler())
			.defaultSuccessUrl("/")
			.failureUrl("/login?error")
			.usernameParameter("username")
			.passwordParameter("password")
			.permitAll();

		http.csrf().disable();

		final RememberMeConfigurer<HttpSecurity> rememberMeConfigurer = http.rememberMe();
		rememberMeConfigurer.key("x");

		// registering the post logout handler
		http.logout()
			.deleteCookies("JSESSIONID")
			.clearAuthentication(true)
			.addLogoutHandler(postLogoutHandler());

		configureSessionManagement(http);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

	@Bean
	public SuccessfulAuthHandler successfulAuthHandler() {
		return new SuccessfulAuthHandler();
	}

	@Bean
	public FailedAuthHandler failedAuthHandler() {
		return new FailedAuthHandler();
	}

	@Bean
	public PostLogoutHandler postLogoutHandler() {
		return new PostLogoutHandler();
	}

	private void configureSessionManagement(HttpSecurity http) throws Exception {
		final SessionManagementConfigurer<HttpSecurity> sessionManagement = http.sessionManagement();
		sessionManagement.maximumSessions(3);
		sessionManagement.invalidSessionStrategy(new SimpleRedirectInvalidSessionStrategy("/login"));
		sessionManagement.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
	}
}
