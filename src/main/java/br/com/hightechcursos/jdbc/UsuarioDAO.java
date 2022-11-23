package br.com.hightechcursos.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hightechcursos.entidades.Usuario;

public class UsuarioDAO {

	private Connection con = Conexao.getConnection();

	public void cadastrar(Usuario usuario) {

		String sql = "INSERT INTO USUARIO (nome,login,senha) VALUES (?,?,?)";

		PreparedStatement preparador;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.execute();
			preparador.close();
			System.out.println("Cadastrado com sucesso");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	
	
	
	public void salvar(Usuario usuario) {
		if(usuario.getId()!=null && usuario.getId()!=0) {
			this.alterar(usuario);
		} else {
			this.cadastrar(usuario);
		}
	}
	
	

	public void alterar(Usuario usuario) {

		String sql = "UPDATE USUARIO SET nome=?,login=?,senha=? WHERE id=?";

		PreparedStatement preparador;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getId());
			preparador.execute();
			preparador.close();
			System.out.println("Alterado com sucesso");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void excluir(Usuario usuario) {

		String sql = "DELETE FROM USUARIO WHERE id=?";

		PreparedStatement preparador;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setInt(1, usuario.getId());
			preparador.execute();
			preparador.close();
			System.out.println("Excluido com sucesso");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public List<Usuario> buscarTodos() {

		String sql = "SELECT * FROM USUARIO";

		List<Usuario> lista = new ArrayList<Usuario>();

		PreparedStatement preparador;
		try {
			preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();
			while (resultado.next()) {
				Usuario usu = new Usuario();
				usu.setId(resultado.getInt("id"));
				usu.setNome(resultado.getString("nome"));
				usu.setLogin(resultado.getString("login"));
				usu.setSenha(resultado.getString("senha"));
				lista.add(usu);
			}
			preparador.close();
			System.out.println("Excluido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public Usuario buscarPorId(Integer id) {
		String sql = "SELECT * FROM Usuario WHERE ID =?";
		PreparedStatement preparador;
		Usuario usuario = null;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);
			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {

				usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
			}

			preparador.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;

	}
	
	
	public List<Usuario> buscarPorNome(String nome) {
		String sql = "SELECT * FROM Usuario WHERE nome LIKE ?";
		PreparedStatement preparador;
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			preparador = con.prepareStatement(sql);
			preparador.setString(1, "%"+nome+"%");
			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {

				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				lista.add(usuario);
			}

			preparador.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}
	
	

	
	
	
	public Usuario autenticar(Usuario usuario) {
		String sql = "SELECT * FROM Usuario WHERE login = ? AND senha = ?";
		PreparedStatement preparador;
		Usuario usuarioRetorno = null;
		try {
			preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getLogin());
			preparador.setString(2,usuario.getSenha());
			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {

				usuarioRetorno = new Usuario();
				usuarioRetorno.setId(resultado.getInt("id"));
				usuarioRetorno.setNome(resultado.getString("nome"));
				usuarioRetorno.setLogin(resultado.getString("login"));
				usuarioRetorno.setSenha(resultado.getString("senha"));
			}

			preparador.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarioRetorno;

	}

}
