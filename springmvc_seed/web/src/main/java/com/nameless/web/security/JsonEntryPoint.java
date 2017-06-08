package com.nameless.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class JsonEntryPoint implements AuthenticationEntryPoint {

	private String url = "/";

	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
			throws IOException, ServletException {
		request.getRequestDispatcher(url).include(request, response);
	}

	public void setUrl(String url) {
		this.url = url;
	}

}