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

import br.com.logmat.dao.PregaoDao;
import br.com.logmat.model.Pregao;

@WebServlet("/cadastroPregao")
public class cadastroPregaoServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numPregao = request.getParameter("numPregao");
		String processo = request.getParameter("processo");
		String DouPregao = request.getParameter("DouPregao");
		String publicacaoDouPregao = request.getParameter("publicacaoDouPregao");

		System.out.println(numPregao + processo + DouPregao + publicacaoDouPregao);

		Pregao p = new Pregao();

		p.setNumPregao(numPregao);
		p.setProcesso(processo);
		p.setDouPregao(DouPregao);
		p.setPublicacaoDouPregao(LocalDate.parse(publicacaoDouPregao));

		PregaoDao pregaoDao = new PregaoDao();

		if (request.getParameter("numPregao") == "") {
			try {
				pregaoDao.adicionarPregao(p);

				String mensagem = "O Pregão foi cadastrado com sucesso!";
				request.setAttribute("MENSAGEM", mensagem);
				RequestDispatcher rd = request.getRequestDispatcher("paginaCadastroPregao.jsp");
				rd.forward(request, response);

				response.sendRedirect("paginaCadastroPregao.jsp");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			p.setNumPregao("numPregao");
			pregaoDao.alterarPregao(p);
			response.sendRedirect("pregaoAlterado.jsp");
		}

	}

}
