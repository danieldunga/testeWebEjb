package br.com.teste.init;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * Servlet implementation class ConfiguraAmbiente
 */
@WebServlet(urlPatterns="/ConfigurarAmbiente", loadOnStartup=1)
public class ConfigurarAmbienteServlet extends HttpServlet {
       
    /** serialVersionUID */
	private static final long serialVersionUID = -4698975635659368645L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ConfigurarAmbienteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Servlet de configuração inicial");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void init() throws ServletException {
		System.out.println("########## Populando banco de dados H2 (em memória) --- ");
		try {
			
			String nomeJNDI = "java:jboss/datasources/ExampleDS"; 
			InitialContext contexto = new InitialContext();

			DataSource dataSource = (DataSource) contexto.lookup(nomeJNDI);
			Connection conn = dataSource.getConnection();

			System.out.println("##### Criando tabela --- ");
			String sql = "CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255))";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			
			System.out.println("##### ISERT 1 --- ");
			sql = "INSERT INTO TEST VALUES(1, 'Hello')";
			stmt = conn.prepareStatement(sql);
			stmt.execute();
			
			System.out.println("##### ISERT 2 --- ");
			sql = "INSERT INTO TEST VALUES(2, 'World')";
			stmt = conn.prepareStatement(sql);
			stmt.execute();

			stmt.close();
			conn.close();
			System.out.println("########## Criação de banco de teste ocorreu com sucesso --- ");
			
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("########## ERRO --- " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("########## ERRO --- " + e.getMessage());
		}
		super.init();
	}

}
