package br.fiap.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.PacienteDAO;
import br.fiap.dao.UsuarioDAO;
import br.fiap.entidades.Paciente;
import br.fiap.entidades.Usuario;

@WebServlet("/listar")
public class ListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		PacienteDAO daoPaciente = new PacienteDAO();
		UsuarioDAO daoUsuario = new UsuarioDAO();
		
		
		
		Usuario usuario = daoUsuario.retornarUsuario(email);
		Paciente paciente = daoPaciente.retornarDadosPaciente(email);
		
		if(paciente == null) {
			PrintWriter out = response.getWriter();
			out.println("<html><body>PACIENTE AINDA NÂO POSSUI DADOS CADASTRADOS</body></html>");
		}else {
			List<String> lista = new ArrayList<String>();
			
			lista.add(usuario.getEmail());
			lista.add(usuario.getNome());
			lista.add(String.valueOf(String.format("%.2f", paciente.getPeso())));
			lista.add(String.valueOf(String.format("%.2f", paciente.getAltura())));
			lista.add(paciente.getGenero());
			lista.add(String.valueOf(String.format("%.2f", paciente.imc())));
			lista.add(paciente.situacao());
			lista.add(String.valueOf(String.format("%.2f", paciente.pesoIdeal())));
			
			request.setAttribute("lista", lista);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listagemDados.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		
		
	}

}
