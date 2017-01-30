package br.gov.ms.defensoria.comum.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	private String contextPath;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		if (session.getAttribute("usuarioLogado") == null) {
			session.invalidate();
			res.sendRedirect(contextPath + "/login.jsf");
		} else {
			res.setHeader("Cache-control", "no-cache, no-store");
			res.setHeader("Pragma", "no-cache");
			res.setHeader("Expires", "-1");
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.contextPath = filterConfig.getServletContext().getContextPath();
	}

}
