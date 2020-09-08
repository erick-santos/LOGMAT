package br.com.logmat.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.logmat.dao.ItemDao;
import br.com.logmat.model.Item;

@WebServlet("/removerItem")
public class RemoverItemServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Item p = new Item();
		
		p.setIdItem(Integer.parseInt(request.getParameter("idItem")));
		
		ItemDao itemdao = new ItemDao();
		itemdao.excluir(p);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaItem");
		rd.forward(request, response);

	}
}
