package controler;

import model.Cavalo;
import model.CavaloDB;


public class CavaloControler {
	private CavaloDB db ;
	public void inserir(Cavalo cavalo) {
		System.out.println("entroi no controler");
		db = new CavaloDB();
		db.adiciona(cavalo);
		
	}
	
	public void Remove(Cavalo cavalo) {
		System.out.println("entroi no controler");
		db = new CavaloDB();
		db.remove(cavalo);
		
	}
	
	public Cavalo Resgatar(int id_cavalo) {
		System.out.println("entroi no controler");
		db = new CavaloDB();
		return db.resgatarCavalo(id_cavalo);
		
			
	}
	
	public void update(Cavalo cavalo) {
		System.out.println("entroi no controler");
		db = new CavaloDB();
		db.update(cavalo);
		
			
	}
}
