package no.jpro.examples.cdiandfilters;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {
	@Inject
	private Instance<UserContext> userContext;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Logging out user " + userContext.get().getName());
		req.getSession().invalidate();
		resp.sendRedirect("/");
	}
}
