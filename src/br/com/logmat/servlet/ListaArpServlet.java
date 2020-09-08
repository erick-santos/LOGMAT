package br.com.logmat.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.logmat.Email;
import br.com.logmat.dao.ArpDao;
import br.com.logmat.dao.ItemDao;

@WebServlet("/listaArp")
public class ListaArpServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArpDao arpDao = new ArpDao();
		ItemDao itemDao = new ItemDao();

		request.setAttribute("lista", arpDao.listarProduto());
		RequestDispatcher rdArp = request.getRequestDispatcher("listaArp.jsp");

		rdArp.forward(request, response);

		
	}
}