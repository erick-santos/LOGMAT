package br.com.logmat.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.logmat.dao.ItemDao;
import br.com.logmat.model.Item;

@WebServlet("/cadastroItem")
public class cadastroItemServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idItem = request.getParameter("idItem");
		String idArp = request.getParameter("idArp");
		
		String numItem = request.getParameter("numItem");
		String nomeItem = request.getParameter("nomeItem");
		String descricaoItem = request.getParameter("descricaoItem");
		String marcaItem = request.getParameter("marcaItem");
		String unidadeItem = request.getParameter("unidadeItem");
		String quantidadeItem = request.getParameter("quantidadeItem");
		String valorUnitarioItem = request.getParameter("valorUnitarioItem");

		Item p = new Item();

		//p.setIdItem(Integer.parseInt(idItem));
		p.setIdArp(Integer.parseInt(idArp));

		p.setNumItem(numItem);
		p.setNomeItem(nomeItem);
		p.setDescricaoItem(descricaoItem);
		p.setMarcaItem(marcaItem);
		p.setUnidadeItem(unidadeItem);

		p.setQuantidadeItem(Double.parseDouble(quantidadeItem.replace(",", ".")));
		p.setValorUnitarioItem(Double.parseDouble(valorUnitarioItem.replace(",", ".")));

		ItemDao itemDao = new ItemDao();

		if (request.getParameter("idItem") == "") {
			try {
				itemDao.adicionarItem(p);

				String mensagem = "O item foi cadastrada com sucesso!";
				request.setAttribute("MENSAGEM", mensagem);
				RequestDispatcher rd = request.getRequestDispatcher("visualizaArp.jsp");
				rd.forward(request, response);

				response.sendRedirect("visualizaArp.jsp");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			//p.setIdItem(Integer.parseInt(request.getParameter("idItem")));
			//itemDao.alterarItem(p);
			//response.sendRedirect("arpAlterada.jsp");
		}

	}

}
