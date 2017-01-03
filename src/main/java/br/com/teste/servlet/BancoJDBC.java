package br.com.teste.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class BancoJDBC
 */
@WebServlet("/BancoJDBC")
public class BancoJDBC extends HttpServlet {
	/** serialVersionUID */
	private static final long serialVersionUID = 4328155426667963374L;

	public BancoJDBC() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msgSaida = "";

		try {
			
			String nomeJNDI = "java:jboss/datasources/ExampleDS"; // Padrão do WildFly
			InitialContext contexto = new InitialContext();

			DataSource dataSource = (DataSource) contexto.lookup(nomeJNDI);
			Connection conn = dataSource.getConnection();

			String sql = "SELECT * FROM TEST ORDER BY ID";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				msgSaida = rs.getString("NAME");
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (NamingException e) {
			e.printStackTrace();
			msgSaida = "NOK - NamingException - " + e.getMessage();
		} catch (SQLException e) {
			e.printStackTrace();
			msgSaida = "NOK - SQLException - " + e.getMessage();
		}

		response.getWriter().append(msgSaida);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
