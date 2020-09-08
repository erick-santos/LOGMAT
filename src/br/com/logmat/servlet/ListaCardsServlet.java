package br.com.logmat.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.logmat.dao.ArpDao;

@WebServlet("/DashBoard")
public class ListaCardsServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArpDao arpDao = new ArpDao();

		// mandar lista de ARPs para a PaginaPrincipal
		
		getServletContext().setAttribute("listaCards", arpDao.listarProduto());
		
		//original:  request.setAttribute("listaCards", produtoDao.listarProduto());
		RequestDispatcher rs = request.getRequestDispatcher("PaginaPrincipal.jsp");
		rs.forward(request, response);
		
	}
}
