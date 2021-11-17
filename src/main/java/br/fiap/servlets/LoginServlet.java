package br.fiap.servlets;

import java.io.IOException;
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

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		UsuarioDAO dao = new UsuarioDAO();
		PacienteDAO daoPaciente = new PacienteDAO();
		if(dao.verificarDadosLogin(email, senha)) {
			
			Usuario usuario = dao.retornarUsuario(email);
			
			if(usuario.getTipoDeUsuario().equals("paciente")) {
				request.setAttribute("usuario", usuario);
				RequestDispatcher dispatcher = request.getRequestDispatcher("paginaPaciente.jsp");
				dispatcher.forward(request, response);	
			}else {
				request.setAttribute("usuario", usuario);
				
				request.setAttribute("listaUsuario", dao.listarUsuarios());
				request.setAttribute("listaPaciente", daoPaciente.listarDadosPacientes());				
				RequestDispatcher dispatcher = request.getRequestDispatcher("paginaADM.jsp");
				dispatcher.forward(request, response);
			}
			
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("usuarioNaoEncontrado.html");
			dispatcher.forward(request, response);
		}
		
	}

}
