package br.fiap.entidades;

public class Paciente{
	
	private String email;
	private double altura;
	private String genero;
	private double peso;
	

	public Paciente(String email, double altura, String genero, double peso) {
		this.email = email;
		this.altura = altura;
		this.genero = genero;
		this.peso = peso;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double imc() {
		return getPeso() / (getAltura() * getAltura());
	}
	
	public String situacao() {
		String situacao = "";
		if(imc() < 20 )
			situacao = "Abaixo do peso";
		else if(imc() >= 20.01 && imc() <= 25)
			situacao = "Normal";
		else if (imc() >= 25.01 && imc() <= 30)
			situacao = "Excesso de peso";
		else
			situacao = "Obesidade";
		
		return situacao;
	}
	
	public double pesoIdeal() {
		double peso = 0;
		if(getGenero().equals("masculino")) 
			peso = 72.7 * getAltura() - 58;
		else
			peso = 62.1 * getAltura() - 44.7;
		
		return peso;
	}
	
	
	
	
	
}
