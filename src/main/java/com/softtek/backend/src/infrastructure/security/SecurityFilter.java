package com.softtek.backend.src.infrastructure.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private TokenService tokenService;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		var token = this.getToken(request);
		
		if (token != null) {
			var username = this.tokenService.validateToken(token);
			UserDetails user = customUserDetailsService.loadUserByUsername(username);

			// if (!user.isEnabled()) {
			// 	response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			// 	return;
			// }

			var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} 
		
		filterChain.doFilter(request, response);
		
	}

	private String getToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		
		if (token == null) return null;
		
		return token.replace("Bearer", "").trim();
	}
}