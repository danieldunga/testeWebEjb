package br.com.teste.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.teste.service.ServicoSingleton;

@WebServlet("/Singleton")
public class Singleton extends HttpServlet {

	private static final long serialVersionUID = -5190144663022324723L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServicoSingleton singleton = ServicoSingleton.getInstance();
		singleton.processa(request.getRequestURI());
		
		response.getWriter().append("Singleton ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
