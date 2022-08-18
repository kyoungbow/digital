package com.booking.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class LoginHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		List<String> roleNames = new ArrayList<>();
		
		auth.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});
		
		if (roleNames.contains("ROLE_MEMBER")){
			response.sendRedirect("/member/index");
			return;
		}
		if (roleNames.contains("ROLE_MANAGER")){
			response.sendRedirect("/member/index");
			return;
		}
		if (roleNames.contains("ROLE_ADMIN")){
			response.sendRedirect("/member/index");
			return;
		}
		
		response.sendRedirect("/");
	}

}
