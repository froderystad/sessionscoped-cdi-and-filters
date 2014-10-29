package no.jpro.examples.cdiandfilters;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = {"/*", "/faces/*"})
public class UserContextFilter implements Filter {
	private static int instanceCounter = 0;
	private int instanceNumber;
	
	@Inject
	private UserContextHolder userContextHolder;
//	private Instance<UserContext> userContext;
	
	public UserContextFilter() {
		instanceNumber = ++instanceCounter;
		System.out.println("UserContextFilter " + instanceNumber + " constructed");
	} 

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("UserContextFilter " + instanceNumber + " initialized");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("UserContextFilter " + instanceNumber +  " filtering request for user " + userContextHolder.getUserContext().getName());
//		System.out.println("UserContextFilter " + instanceNumber +  " filtering request for user " + userContext.get().getName());
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("UserContextFilter " + instanceNumber + " destroyed");
	}
} 