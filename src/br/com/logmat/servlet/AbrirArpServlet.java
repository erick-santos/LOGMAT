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

@WebServlet("/abrirArp")
public class AbrirArpServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Arp p = new Arp();
		p.setIdArp(Integer.parseInt(request.getParameter("idarp")));
			
		ArpDao arpdao = new ArpDao();
		request.setAttribute("arpModal", arpdao.selecionarProdutoById(p));
		RequestDispatcher rd = request.getRequestDispatcher("visualizaArp.jsp");
		rd.forward(request, response);
	}

}
