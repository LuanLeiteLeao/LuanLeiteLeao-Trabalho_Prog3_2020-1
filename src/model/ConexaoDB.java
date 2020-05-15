/*
esta classe tem como responsabilidade fazer a conecxao com o banco de dados,
esta classe só pode ser instanciada uma vez, por esse motivo eu usei o padrao 
de projeto Singleton, ele me permite criar uma classe global, eu não precisso 
instanciar ela para poder usar, ela é unica, eu só posso fazer uma conecxao com 
o banco de dados.
*/
package model;

import com.mysql.jdbc.Driver;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class ConexaoDB {
	// instanciado o meu objeto na minha propria classe "Auto Propri se referencia
	// kjljlkjlkjkljk "
	private static ConexaoDB unicaInstancia = new ConexaoDB();

	private static ConexaoDB dao;
	private Connection con;
	public static final String SERVIDOR = "localhost";
	public static final String BANCO_NOME = "sistema_cavalos";
	public static final String USUARIO_NOME = "javaApp";
	public static final String USUARIO_SENHA = "123456789";

	private ConexaoDB() {
//		this.inicializarDriverConexao();
		this.inicializarConexao();

	}

	// como a minha class só pode ter uma instancia,é precisso ter um metodo que
	// retorna o mesmo

	public static synchronized ConexaoDB getInstance() {
		if (unicaInstancia == null)
			unicaInstancia = new ConexaoDB();

		return unicaInstancia;
	}

	private void inicializarConexao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + SERVIDOR + "/" + BANCO_NOME, USUARIO_NOME,
					USUARIO_SENHA);
			System.out.println("conectado!!");

		} catch (SQLException e) {
			System.out.println("Erro de conex�o");
			e.printStackTrace();
			System.exit(2);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void inicializarDriverConexao() {
	
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/");
			System.out.println("Conectado!");
		} catch ( SQLException e) {
			System.out.println("Falha ao carregar o Driver de conex�o com banco de dados Postgresql");
			e.printStackTrace();
			System.exit(1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getCon() {

		return this.con;
	}
}
