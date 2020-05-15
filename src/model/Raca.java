package model;

public class Raca {
	public Integer id;
	public String nomeBr;
	public String nomeEng;
	private String paisOrigem;
	private String uso;
	private String temperamento;
	private String breveHistoria;
	
	
	public Raca(String nomeBr, String nomeEng,String paisOrigem,
			String uso,String temperamento,String breveHistoria) {

			
		this.nomeBr = nomeBr;
		this.nomeEng=nomeEng;
		this.paisOrigem = paisOrigem;
		this.uso=uso;
		this.temperamento=temperamento;
		this.breveHistoria=breveHistoria;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeBr() {
		return nomeBr;
	}
	public void setNomeBr(String nomeBr) {
		this.nomeBr = nomeBr;
	}
	public String getNomeEng() {
		return nomeEng;
	}
	public void setNomeEng(String nomeEng) {
		this.nomeEng = nomeEng;
	}
	public String getPaisOrigem() {
		return paisOrigem;
	}
	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}
	public String getUso() {
		return uso;
	}
	public void setUso(String uso) {
		this.uso = uso;
	}
	public String getTemperamento() {
		return temperamento;
	}
	public void setTemperamento(String temperamento) {
		this.temperamento = temperamento;
	}
	public String getBreveHistoria() {
		return breveHistoria;
	}
	public void setBreveHistoria(String breveHistoria) {
		this.breveHistoria = breveHistoria;
	}
	
	public void save() {
		
		
	}
	
}