package com.manager.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import com.manager.dto.UserLoginDTO;
import com.manager.service.JwtService;
import com.manager.service.UserService;

@ComponentScan(basePackages = "com.manager.service")
public class JwtAuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {

	private final static String TOKEN_HEADER = "authorization";
	@Autowired
	private JwtService jwtService;
	@Autowired
	private UserService userService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("beenndnnd");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String authToken = httpRequest.getHeader(TOKEN_HEADER);
		if (jwtService.validateTokenLogin(authToken)) {
			String email = jwtService.getEmailFromToken(authToken);
			System.out.println("authemail" + email);
			com.manager.entity.User user = userService.checkUserEmail(email);
			System.out.println(user.getEmail() + "role");
			if (user != null) {
				UserLoginDTO userLoginDTO = new UserLoginDTO();
				userLoginDTO.setEmail(user.getEmail());
				userLoginDTO.setPassword(user.getPassword());
				userLoginDTO.setRole(new String[] { user.getRole().getRoleName() });
				boolean enabled = true;
				boolean accountNonExpired = true;
				boolean credentialsNonExpired = true;
				boolean accountNonLocked = true;
				UserDetails userDetail = new User(userLoginDTO.getEmail(), userLoginDTO.getPassword(), enabled, accountNonExpired,
						credentialsNonExpired, accountNonLocked, userLoginDTO.getAuthorities());
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail,
						null, userDetail.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		chain.doFilter(request, response);
	}

}
