package br.com.teste.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.teste.service.ServicoEJB;

/**
 * Servlet implementation class Teste02
 */
@WebServlet("/Teste03")
public class Teste03 extends HttpServlet {
	private static final long serialVersionUID = -8671290930442301071L;

	@Inject
	ServicoEJB ejb;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		ServicoNormal normal = new ServicoNormal();
//		normal.processa(request.getRequestURI());
		
//		ServicoSingleton singleton = ServicoSingleton.getInstance();
//		singleton.processa(request.getRequestURI());
		
		//ejb.processa(request.getRequestURI());
		
		response.getWriter().append("Served at: ").append(request.getContextPath()).append(" 123 ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
