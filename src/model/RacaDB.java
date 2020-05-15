package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class RacaDB {
	private ConexaoDB db;
	private Connection con;
	private PreparedStatement stmt;

	public RacaDB() {
		this.db = ConexaoDB.getInstance();
		this.con = (Connection) this.db.getCon();
	}

	public String adiciona(Raca raca) {
		String sql = "insert into raca " + "(nome_br,nome_eng,paisOrigem,uso," + "	temperamento,breveHistoria)"
				+ " values (?,?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = (PreparedStatement) this.con.prepareStatement(sql);

			// seta os valores

			stmt.setString(1, raca.getNomeBr());
			stmt.setString(2, raca.getNomeEng());
			stmt.setString(3, raca.getPaisOrigem());
			stmt.setString(4, raca.getUso());
			stmt.setString(5, raca.getTemperamento());
			stmt.setString(6, raca.getBreveHistoria());

			// executa
			stmt.execute();
			stmt.close();

			System.out.println("Salvo Com Sucesso");
			return "Salvo Com Sucesso";

		} catch (SQLException e) {
			System.out.println("Deu Ruim");
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}

	public String deleta(Raca raca) {
		try {
			PreparedStatement stmt = (PreparedStatement) this.con.prepareStatement("delete from raca where id=?");
			stmt.setLong(1, raca.getId());
			stmt.execute();
			stmt.close();

			System.out.println("Excluído com Sucesso");

			return "Excluído com Sucesso";
		} catch (SQLException e) {
			System.out.println("Deu Ruim");
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}

	public Raca resgatarRaca(int id) {
		Raca raca = null;

		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) this.con.prepareStatement("SELECT * FROM raca WHERE id=?;");

			stmt.setLong(1, id);

			// executa um select
			ResultSet rs = stmt.executeQuery();

			// itera no ResultSet

			while (rs.next()) {
				raca = new Raca(rs.getString("nome_br"), rs.getString("nome_eng"), rs.getString("paisOrigem"),
						rs.getString("uso"), rs.getString("temperamento"), rs.getString("breveHistoria"));

				raca.setId(rs.getInt("id"));

				System.out.println("Deu Bom");
			}

			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return raca;

	}

	public ArrayList<Raca> resgatarTodasRacas() {

		ArrayList<Raca> livros = new ArrayList<Raca>();
		// pega a conexão e o Statement

		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) this.con.prepareStatement("SELECT * FROM raca;");

			// executa um select
			ResultSet rs = stmt.executeQuery();

			// itera no ResultSet

			while (rs.next()) {
				Raca raca = new Raca(rs.getString("nome_br"), rs.getString("nome_eng"), rs.getString("paisOrigem"),
						rs.getString("uso"), rs.getString("temperamento"), rs.getString("breveHistoria"));

				raca.setId(rs.getInt("id"));
				livros.add(raca);

				System.out.println("Deu Bom");
			}

			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return livros;
	}

}
