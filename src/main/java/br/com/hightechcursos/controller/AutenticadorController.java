package br.com.hightechcursos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;



import br.com.hightechcursos.entidades.Usuario;
import br.com.hightechcursos.jdbc.UsuarioDAO;

/**
 * Servlet implementation class AutenticadorController
 */
public class AutenticadorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AutenticadorController() {
        super();
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(false);
		if(sessao!=null) {
			sessao.invalidate();
		}
		response.sendRedirect("login.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Captura dados da tela
		String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setSenha(senha);
        
        // busca no banco
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        Usuario usuRetorno = usuarioDAO.autenticar(usuario);
        
        if (usuRetorno!=null) {
        	
        	// criando a sessao
        	HttpSession sessao = request.getSession();
        	sessao.setMaxInactiveInterval(3000);
        	sessao.setAttribute("usuLogado", usuRetorno);
        	
        	// encaminhando ao index
        	
        	request.getRequestDispatcher("index.jsp").forward(request, response);
        	
        } else {
        	
        	response.sendRedirect("login.html");
        }
        
        
        
	}

}
