package br.com.logmat.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.logmat.dao.ArpDao;
import br.com.logmat.model.Arp;

@WebServlet("/cadastroArp")
public class cadastroArpServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idArp = request.getParameter("idArp");
		String numArp = request.getParameter("numArp");
		String dataAssinaturaArp = request.getParameter("dataAssinaturaArp");
		String inicioVigenciaArp = request.getParameter("inicioVigenciaArp");
		String fimVigenciaArp = request.getParameter("fimVigenciaArp");
		String superintendente = request.getParameter("superintendente");
		String representanteFornecedor = request.getParameter("representanteFornecedor");
		String valorARP = request.getParameter("valorARP");
		String fornecedorArp = request.getParameter("fornecedorArp");
		String fornecedorCNPJ = request.getParameter("fornecedorCNPJ");
		String objetoArp = request.getParameter("objetoArp");
		String numPregaoArp = request.getParameter("numPregaoArp");
		
		Arp p = new Arp();

		p.setNumArp(numArp);
		
		p.setDataAssinaturaArp(LocalDate.parse(dataAssinaturaArp));
		p.setInicioVigenciaArp(LocalDate.parse(inicioVigenciaArp));
		p.setFimVigenciaArp(LocalDate.parse(fimVigenciaArp));
		p.setSuperintendente(superintendente);
		p.setRepresentanteFornecedor(representanteFornecedor);
		p.setFornecedorArp(fornecedorArp);
		p.setFornecedorCNPJ(fornecedorCNPJ);
		p.setObjetoArp(objetoArp);
		p.setValorARP(Double.parseDouble(valorARP.replace(",", ".")));
		p.setNumPregaoArp(numPregaoArp);

		ArpDao arpDao = new ArpDao();

		if(request.getParameter("idArp") == "") {
			try {
				arpDao.adicionarArp(p);
				
				String mensagem = "A ARP foi cadastrada com sucesso!";
				request.setAttribute("MENSAGEM", mensagem);
				RequestDispatcher rd = request.getRequestDispatcher("paginaCadastroArp.jsp");
				rd.forward(request, response);
				
				response.sendRedirect("paginaCadastroArp.jsp");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			p.setIdArp(Integer.parseInt(request.getParameter("idArp")));
			arpDao.alterarArp(p);
			response.sendRedirect("arpAlterada.jsp");
		}
		
		
		
		

	}

}
