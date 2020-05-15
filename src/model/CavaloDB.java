package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CavaloDB {
	private ConexaoDB db;
	private Connection con;
	private PreparedStatement stmt;
	
	public CavaloDB() {
		this.db = ConexaoDB.getInstance();
		this.con = (Connection) this.db.getCon();
	}
	
	public String adiciona(Cavalo cavalo) {

		
        String sql = "insert into cavalo " +
                "(nome, altura, cor_pelo, peso ,"
                + "alimentacao, raca_id)" +
                " values (?,?,?,?,?,?)";
        
        

        try {
            // prepared statement para inserção
            PreparedStatement stmt = (PreparedStatement) this.con.prepareStatement(sql);

            // seta os valores
            stmt.setString(1,cavalo.getNome());
            stmt.setFloat(2,cavalo.getAltura());
            stmt.setString(3,cavalo.getCorPelo());
            stmt.setFloat(4,cavalo.getPeso());
            stmt.setString(5,cavalo.getAlimentacao());
            stmt.setInt(6,cavalo.getRaca().getId());
            
          
            
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
	
	public String remove(Cavalo cavalo) {
		 try {
             PreparedStatement stmt = (PreparedStatement) this.con.prepareStatement("delete from cavalo where id=?");
             stmt.setLong(1, cavalo.getId());
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
	
	public Cavalo resgatarCavalo(int id) {
	
	    PreparedStatement stmt;
	    Cavalo c = null;
		try {
			stmt = (PreparedStatement) this.con.prepareStatement("SELECT * FROM cavalo WHERE id=?;");
		
	    stmt.setLong(1, id);
	   
	    // executa um select
	    ResultSet rs = stmt.executeQuery();

	    // itera no ResultSet
	    
	    if(rs != null && rs.next()) {

		    RacaDB dbRaca = new RacaDB();
			Raca raca = dbRaca.resgatarRaca(rs.getInt("raca_id"));
				
		     c = new Cavalo(rs.getInt("id"), rs.getString("nome"),
					rs.getFloat("altura"),rs.getString("cor_pelo"),
					rs.getFloat("peso"),rs.getString("alimentacao"), raca);
					
				

				    System.out.println("Deu Bom");

	    }
	   			
		
	    stmt.close();
	    
	    return c;
	    
	    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
			
	}
	

	public ArrayList<Cavalo> resgatarTodosCavalo() {
		
		 ArrayList<Cavalo> livros = new ArrayList<Cavalo>(); 
		 // pega a conexão e o Statement
	   
	    PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) this.con.prepareStatement("SELECT * FROM cavalo;");
		
	    
	   
	    // executa um select
	    ResultSet rs = stmt.executeQuery();

	    // itera no ResultSet
	
	   
	
			while (rs.next()) {
//				nome, altura, cor_pelo, peso ,"
//		                + "alimentacao, raca_id)"
				
				RacaDB dbRaca = new RacaDB();
				Raca raca = dbRaca.resgatarRaca(rs.getInt("raca_id"));
				
				Cavalo c = new Cavalo(rs.getInt("id"), rs.getString("nome"),
						rs.getFloat("altura"),rs.getString("cor_pelo"),
						rs.getFloat("peso"),rs.getString("alimentacao"), raca);
						
				System.out.println(rs.getInt("id"));		
				
				
				livros.add(c);

			    System.out.println("Deu Bom-------");
			}
		
	    stmt.close();
	   
	    
	    
	    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return livros;	
	}
	
	

	public void update(Cavalo cavalo) {
//		UPDATE `funcionarios` SET `nome` = "Diego Macêdo", `funcao` = "Desenvolvedor Web" WHERE `id_funcionario` = 10;

		PreparedStatement stmt;
		try {
	
			
			stmt = (PreparedStatement) this.con
					.prepareStatement("UPDATE  cavalo SET" + " nome=?, altura=?, cor_pelo=?, peso=? ," 
							 +"alimentacao=?, raca_id=?   WHERE id=?;");

			stmt.setString(1, cavalo.getNome());
			stmt.setFloat(2, cavalo.getAltura());
			stmt.setString(3, cavalo.getCorPelo());
			stmt.setFloat(4, cavalo.getPeso());
			stmt.setString(5, cavalo.getAlimentacao());
			stmt.setInt(6, cavalo.getRaca().getId());
			stmt.setInt(7, cavalo.getId());

			// executa um select

			stmt.execute();
			stmt.close();
			System.out.println("Deu Bom , objeto update");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Deu Ruim , objeto update");
			e.printStackTrace();
		}

	}

	
}
