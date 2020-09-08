package br.com.logmat.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.logmat.dao.ArpDao;

@WebServlet("/listaPregao")
public class ListaPregaoServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numPregaoArp = request.getParameter("numPregaoArp");
		ArpDao arpDao = new ArpDao();
				
		System.out.println(numPregaoArp);
		request.setAttribute("listaPregao", arpDao.listarProduto());
		RequestDispatcher rd = request.getRequestDispatcher("listaPregao.jsp");

		rd.forward(request, response);

	}
}