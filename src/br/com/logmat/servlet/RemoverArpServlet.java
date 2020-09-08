package br.com.logmat.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.logmat.dao.ArpDao;
import br.com.logmat.model.Arp;

@WebServlet("/remover")
public class RemoverArpServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Arp p = new Arp();
		
		p.setIdArp(Integer.parseInt(request.getParameter("idarp")));
		System.out.println(Integer.parseInt(request.getParameter("idarp")));
		ArpDao arpdao = new ArpDao();
		arpdao.excluir(p);
		
		RequestDispatcher rd = request.getRequestDispatcher("listaArp");
		rd.forward(request, response);

	}
}
