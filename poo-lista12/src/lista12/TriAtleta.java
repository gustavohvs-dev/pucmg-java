package lista12;

public class TriAtleta extends Humano implements Ciclista, Corredor, Nadador {
	
	public TriAtleta (String nome) {
		super(nome);
	}
	
	@Override
	public void nadar() {
		System.out.println("O atleta está nadando");
	}
	
	@Override
	public void correr() {
		System.out.println("O atleta está correndo");
	}
	
	@Override
	public void pedalar() {
		System.out.println("O atleta está pedalando");
	}
	
	@Override
	public String toString() {
		return "Triatleta: " + getNome();
	}

}
