package br.com.teste.servlet.info;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class Ambiente
 */
@WebServlet("/Ambiente")
public class Ambiente extends HttpServlet {
       
    /** serialVersionUID */
	private static final long serialVersionUID = 3990929709784309612L;

	/** Log4j */
	private Logger log = Logger.getLogger(getClass());
	
	
	/** @see HttpServlet#HttpServlet() */
    public Ambiente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("<p>Inicio.");
		for (Entry<String, String> entry : System.getenv().entrySet()) {
			response.getWriter().append("<p>" + entry.getKey() + "=" + entry.getValue());
		}
		// TODO Auto-generated method stub
		response.getWriter().append("<p>Fim.");
		log.error("Obtendo variável da JVN de nome BOOTSTRAP_PORT. Valor encontrado: " + System.getProperty("BOOTSTRAP_PORT"));
		log.error("Teste obtendo propriedade padrao: " + System.getProperty("qualquer.coisa","valorDefault"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
