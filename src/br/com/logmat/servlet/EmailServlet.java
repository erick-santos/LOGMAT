package br.com.logmat.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.logmat.AutoVerificacao;
import br.com.logmat.Email;

@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AutoVerificacao av = new AutoVerificacao();
		av.emailVerificacao();
		
		Email e = new Email();
		e.mandarEmail("mensagem de teste", "Testando como mandar emails no java", "emsusp@gmail.com");
		response.sendRedirect("index.jsp");
	}

}
