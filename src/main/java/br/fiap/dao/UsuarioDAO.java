package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.conexao.Conexao;
import br.fiap.entidades.Usuario;

public class UsuarioDAO {

	private String sql;
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection connection;
	
	public UsuarioDAO() {
		connection = Conexao.conectar();
	}
	
	public void inserir(Usuario usuario) {
		sql = "INSERT INTO tb_usuario values(?, ?, ?, ?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getTipoDeUsuario());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("ERRO AO INSERIR" + e);
		}
	}
	
	public boolean verificarDadosLogin(String email, String senha) {
		boolean aux = false;
		sql = "SELECT * FROM tb_usuario WHERE email = ? AND senha = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, senha);
			rs = ps.executeQuery();
			aux = rs.next();
		}catch(SQLException e) {
			System.out.println("ERRO AO CONFERIR DADOS DE LOGIN" + e);
		}
		return aux;
	}
	//esse método serve para retornar um usuário baseado em seu email, 
	//serve para identificar se o tipo do usuario na hora do login e para listar os dados 
	public Usuario retornarUsuario(String email) {
		Usuario usuario = null;
		sql = "SELECT * FROM tb_usuario WHERE email = ? ";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next()) {
				 usuario = new Usuario(rs.getString("email"),rs.getString("nome"),rs.getString("senha"),rs.getString("tipodeusuario"));
			}
		}catch(SQLException e ) {
			System.out.println("ERRO AO RETORNAR USUARIO" + e);
		}
		return usuario;
	}
	
	public List<Usuario> listarUsuarios(){
		List<Usuario> lista = new ArrayList<Usuario>();
		sql = "SELECT * FROM tb_usuario";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				lista.add(new Usuario(rs.getString("email"),rs.getString("nome"),rs.getString("senha"),rs.getString("tipodeusuario")));
			}
		}catch(SQLException e) {
			System.out.println("ERRO AO LISTAR USUARIOS " + e);
		}
		
		return lista;
	}
	
}
