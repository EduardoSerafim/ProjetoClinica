package br.fiap.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.PacienteDAO;
import br.fiap.entidades.Paciente;


@WebServlet("/paciente")
public class PacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double altura = Double.parseDouble(request.getParameter("altura"));
		double peso = Double.parseDouble(request.getParameter("peso"));
		String genero = request.getParameter("genero");
		String email = request.getParameter("email");
		
		Paciente paciente = new Paciente(email, altura, genero, peso);
		
		PacienteDAO dao = new PacienteDAO();
		if(dao.verificarDadosPaciente(email)) {
			PrintWriter out = response.getWriter();
			out.println("<html><body>DADOS DO USUÁRIO JÀ CADASTRADOS NO BANCO</body></html>");
		}else {
			dao.inserir(paciente);
			RequestDispatcher dispatcher = request.getRequestDispatcher("dadosPaciente.html");
			dispatcher.forward(request, response);			
		}
		
		
		
		
	}

}
