package model;

public class Cavalo {
	private Integer id;
	private String nome;
	private Float altura;
	private String corPelo;
	private Float peso;
	private String alimentacao;
	private Raca raca;
	
	public Cavalo(Integer id,String nome, Float altura,String corPelo,
			Float peso, String alimentacao,Raca raca) {
		
		this.id=id;
		this.nome=nome;
		this.altura=altura;
		this.corPelo=corPelo;
		this.peso=peso;
		this.alimentacao=alimentacao;
		this.raca=raca;
		
		
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Float getAltura() {
		return altura;
	}
	public void setAltura(Float altura) {
		this.altura = altura;
	}
	public String getCorPelo() {
		return corPelo;
	}
	public void setCorPelo(String corPelo) {
		this.corPelo = corPelo;
	}
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	public String getAlimentacao() {
		return alimentacao;
	}
	public void setAlimentacao(String alimentacao) {
		this.alimentacao = alimentacao;
	}
	public Raca getRaca() {
		return raca;
	}
	public void setRaca(Raca raca) {
		this.raca = raca;
	}
	

}
