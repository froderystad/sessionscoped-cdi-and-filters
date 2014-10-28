package no.jpro.examples.cdiandfilters;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named
public class WelcomeController {
	private static int instanceCounter;
	private int instanceNumber;
	
	@Inject
	private UserContext userContext;

	public WelcomeController() {
		instanceNumber = ++instanceCounter;
		System.out.println("WelcomeController instance " + instanceNumber + " constructed");
	}
	
	public String getName() {
		System.out.println("WelcomeController instance " +  instanceNumber + " returned " + userContext.getName());
		return userContext.getName();
	}
}
