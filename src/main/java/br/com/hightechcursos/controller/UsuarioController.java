package br.com.hightechcursos.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.com.hightechcursos.entidades.Usuario;
import br.com.hightechcursos.jdbc.UsuarioDAO;

//@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		System.out.println("Chamando o metodo doget e executando a acao: " + acao);

		if (acao != null && acao.equals("exc")) {

			System.out.println("Entrando no excluir: " );
			String id = request.getParameter("id");
			Usuario usuario = new Usuario();
			usuario.setId(Integer.parseInt(id));
			usuarioDAO.excluir(usuario);

		}

		if (acao != null && acao.equals("alt")) {
			System.out.println("Entrando no alterar: " );
			// captura parametro da tela
			String id = request.getParameter("id");
			// busca objeto usuario
			Usuario usuario = usuarioDAO.buscarPorId(Integer.parseInt(id));
			// seta atributo no request
			request.setAttribute("usuario", usuario);
			// encaminha objeto usuario para o formulario
			RequestDispatcher saida = request.getRequestDispatcher("frmusuario.jsp");
			saida.forward(request, response);

		}

		if (acao != null && acao.equals("lis")) {
			System.out.println("Entrando no listar: " );
			List<Usuario> usuarios = usuarioDAO.buscarTodos();

			// "engavetar"no request
			request.setAttribute("lista", usuarios);

			// encaminhamento
			RequestDispatcher saida = request.getRequestDispatcher("listausuarios.jsp");
			saida.forward(request, response);

		}
		
		if (acao != null && acao.equals("cad")) {
			System.out.println("Entrando no cadastrar: " );
		   
			Usuario usuario = new Usuario();
			usuario.setId(0);
			usuario.setNome("");
			usuario.setLogin("");
			usuario.setSenha("");
			// seta atributo no request
			request.setAttribute("usuario", usuario);
			// encaminha objeto usuario para o formulario
			RequestDispatcher saida = request.getRequestDispatcher("frmusuario.jsp");
			saida.forward(request, response);
			
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Chamando o metodo dopost");

		String id = request.getParameter("txtid");
		String nome = request.getParameter("txtnome");
		String login = request.getParameter("txtlogin");
		String senha = request.getParameter("txtsenha");

		// cria o objeto
		Usuario usuario = new Usuario();

		if (id != null && id != "" & id != "0") {
			usuario.setId(Integer.parseInt(id));
		}

		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);

		// cadastra o usuario
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);

		// saida para o browser
		PrintWriter saida = response.getWriter();
		saida.print("Salvo");
	}

}
