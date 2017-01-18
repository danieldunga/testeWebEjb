package br.com.teste.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.teste.service.ServicoAssincronoEJB;

/**
 * Servlet implementation class Sincrono
 */
@WebServlet("/Sincrono")
public class Sincrono extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ServicoAssincronoEJB servicoAssincronoEJB;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sincrono() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inicio da Servlet de teste EJB Sincrono");
		servicoAssincronoEJB.servicoSincrono();
		System.out.println("Fim da Servlet de teste EJB Sincrono");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
