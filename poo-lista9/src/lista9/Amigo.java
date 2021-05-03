package lista9;

public class Amigo extends Contato {
	
	private int grauAmizade;
	
	public Amigo(String nome, String apelido, String email, int grauAmizade) {
		this.setNome(nome);
		this.setApelido(apelido);
		this.setEmail(email);
		this.setGrauAmizade(grauAmizade);
	}
	
	public void setGrauAmizade(int param) {
		this.grauAmizade = param;
	}
	
	public int getAmizade() {
		return this.grauAmizade;
	}
	
	public void confraterniza(String param) {
		System.out.println("Confraternizando com " + this.getNome() + " em " + param);
	}

}
