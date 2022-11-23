package br.com.hightechcursos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.autenticar(usuario)
        
        
        
	}

}
