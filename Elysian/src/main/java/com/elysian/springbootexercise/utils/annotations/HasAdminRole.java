package com.elysian.springbootexercise.utils.annotations;

import com.elysian.springbootexercise.security.Roles;
import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasRole('" + Roles.ADMIN_ROLE + "')")
public @interface HasAdminRole {
}
