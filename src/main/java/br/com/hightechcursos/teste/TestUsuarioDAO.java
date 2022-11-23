package br.com.hightechcursos.teste;

import java.util.List;

import br.com.hightechcursos.entidades.Usuario;
import br.com.hightechcursos.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		
		//testCadastrar();
		//testAlterar();
		//testExcluir();
		//testBuscarTodos();
		//testAutenticar();
		//testBuscarPorId();

	}

	public static void testCadastrar() {
		Usuario usu = new Usuario();
		
		usu.setNome("glauco miranda");
		usu.setLogin("gla1980");
		usu.setSenha("1989");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		
		usuDAO.cadastrar(usu);
	}
	
	
	public static void testAlterar() {
		Usuario usu = new Usuario();
		
		usu.setId(2);
		usu.setNome("Jontex");
		usu.setLogin("jon");
		usu.setSenha("jj123");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		
		usuDAO.alterar(usu);
	}
	
	
	public static void testExcluir() {
		Usuario usu = new Usuario();
		
		usu.setId(2);
			
		UsuarioDAO usuDAO = new UsuarioDAO();
		
		usuDAO.excluir(usu);
	}
	
	
	public static void testBuscarTodos() {
		
        UsuarioDAO usuDAO = new UsuarioDAO();
		
		List<Usuario> listaResultado = usuDAO.buscarTodos();
		
		for(Usuario u:listaResultado) {
			System.out.println(u.getId()+" "+u.getNome()+" "+u.getLogin());
		}
		
	}
	
	
	public static void testAutenticar() {
		Usuario usuario = new Usuario();
		usuario.setLogin("jj");
		usuario.setSenha("123");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		System.out.println(usuarioDAO.autenticar(usuario));
	}


	public static void testBuscarPorId() {
		UsuarioDAO usuDAO = new UsuarioDAO();
	    System.out.println(usuDAO.buscarPorId(4));
	}

}
