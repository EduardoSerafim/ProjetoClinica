package br.fiap.entidades;

public class Usuario {
	
	private String email;
	private String nome;
	private String senha;
	private String tipoDeUsuario;
	
	public Usuario(String email, String nome, String senha, String tipoDeUsuario) {

		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.tipoDeUsuario = tipoDeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoDeUsuario() {
		return tipoDeUsuario;
	}

	public void setTipoDeUsuario(String tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}
	
	
	
	
}
