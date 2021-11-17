package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.conexao.Conexao;
import br.fiap.entidades.Paciente;
import br.fiap.entidades.Usuario;

public class PacienteDAO {

	private String sql;
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection connection;
	
	public PacienteDAO(){
		connection = Conexao.conectar();
	}
	
	public void inserir(Paciente paciente) {
		sql = "INSERT INTO tb_paciente values(?, ?, ?, ?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, paciente.getEmail());
			ps.setDouble(2, paciente.getAltura());
			ps.setString(3, paciente.getGenero());
			ps.setDouble(4, paciente.getPeso());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("ERRO AO INSERIR" + e);
		}
	}
	
	public Paciente retornarDadosPaciente(String email) {
		Paciente paciente = null;
		sql = "SELECT * FROM tb_paciente WHERE emailusuario = ? ";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next()) {
				 paciente = new Paciente (rs.getString("emailusuario"),rs.getDouble("altura"),rs.getString("genero"),rs.getDouble("peso"));
			}
		}catch(SQLException e ) {
			System.out.println("ERRO AO RETORNAR DADOS DO PACIENTE" + e);
		}
		return paciente;
	}
	
	public List<Paciente> listarDadosPacientes(){
		List<Paciente> lista = new ArrayList<Paciente>();
		sql = "SELECT * FROM tb_paciente";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				lista.add(new Paciente(rs.getString("emailusuario"),rs.getDouble("altura"),rs.getString("genero"),rs.getDouble("peso")));
			}
		}catch(SQLException e) {
			System.out.println("ERRO AO LISTAR DADOS DO PACIENTE" + e);
		}
		
		return lista;
	}
	
	public boolean verificarDadosPaciente(String email) {
		boolean aux = false;
		sql = "SELECT * FROM tb_paciente WHERE emailusuario = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			aux = rs.next();
		}catch(SQLException e) {
			System.out.println("ERRO AO CONFERIR DADOS DE LOGIN" + e);
		}
		return aux;
	}

	
}
