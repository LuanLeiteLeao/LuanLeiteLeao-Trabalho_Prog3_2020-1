package controler;

import model.Raca;
import model.RacaDB;

public class RacaControler {
	private RacaDB db ;
	public void inserir(Raca raca) {
		db = new RacaDB();
		db.adiciona(raca);
		
	}
}
