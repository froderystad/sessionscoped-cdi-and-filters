package no.jpro.examples.cdiandfilters;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named
public class LoginController {
	private static int instanceCounter;
	private int instanceNumber;

	@Inject
	private UserContextHolder userContextHolder;

	private String name;

	public LoginController() {
		instanceNumber = ++instanceCounter;
		System.out.println("LoginController instance " + instanceNumber + " constructed");
	}

	public void setName(String name) {
		System.out.println("LoginController instance " + instanceNumber + " recevied name " + name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void login() throws IOException {
		System.out.println("LoginController instance " + instanceNumber + " recevied action 'login'");
		userContextHolder.getUserContext().setName(name);

		FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/welcome.xhtml");
	}
}
