package br.com.hightechcursos.controller;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class FiltroAutentica extends HttpFilter implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FiltroAutentica() {
		super();
		
	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		
		// Casting do HttpServlet request
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String url = httpServletRequest.getRequestURI();
		
		// Capturando Sessao
		HttpSession sessao = httpServletRequest.getSession();
		
		if(sessao.getAttribute("usuLogado")!=null || url.lastIndexOf("login.html")>-1 || url.lastIndexOf("autcontroller.do")>-1) {
			chain.doFilter(request, response);
		} else {
			// redireciona para login
			((HttpServletResponse) response).sendRedirect("login.html");
		}
		
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
