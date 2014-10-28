package no.jpro.examples.cdiandfilters;

import javax.enterprise.inject.Typed;

@Typed // unregisters this class as "UserContext"
public class UserContext {
	private static int instanceCounter;
	private int instanceNumber;
	
	private String name;
	
	public UserContext() {
		instanceNumber = ++instanceCounter;
		System.out.println("UserContext instance " + instanceNumber + " constructed");
	}

	public String getName() {
		System.out.println("UserContext instance " + instanceNumber + " returning name " + name);
		return name;
	}

	public void setName(String name) {
		System.out.println("UserContext instance " + instanceNumber + " received name " + name);
		this.name = name;
	}
}
