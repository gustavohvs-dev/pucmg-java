package lista12;

public class Humano {
	
	private String nome;
	
	public Humano(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	@Override
	public String toString() {
		return "Humano:" + this.nome;
	}

}
