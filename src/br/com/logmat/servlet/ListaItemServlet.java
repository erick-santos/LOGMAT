package br.com.logmat.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.logmat.dao.ItemDao;


@WebServlet("/listaItem")
public class ListaItemServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemDao itemDao = new ItemDao();
		
		String idArp = request.getParameter("idArp");
		System.out.println(idArp);
		
		request.setAttribute("listaItem", itemDao.listarItem(idArp));
		RequestDispatcher rd = request.getRequestDispatcher("listaItem.jsp");

		rd.forward(request, response);

	}
}