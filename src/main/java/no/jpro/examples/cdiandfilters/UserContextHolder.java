package no.jpro.examples.cdiandfilters;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

import java.io.Serializable;

@SessionScoped
public class UserContextHolder implements Serializable {
	private static int instanceCounter;
	private int instanceNumber;
	
	private UserContext userContext;

	public UserContextHolder() {
		instanceNumber = ++instanceCounter;
		System.out.println("UserContextHolder instance " + instanceNumber + " constructed");
	}
	
	@Produces
	public UserContext getUserContext() {
		if (userContext == null) {
			userContext = new UserContext();
		}
		System.out.println("UserContextHolder instance " + instanceNumber + " returns user context for " + userContext.getName());
		return userContext;
	}

	public void setUserContext(UserContext userContext) {
		this.userContext = userContext;
	}
}
