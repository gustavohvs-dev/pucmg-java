package lista9;

public class Familiar extends Contato {
	
	private String grauDeParentesco;
	
	public Familiar(String nome, String apelido, String email, String grauDeParentesco) {
		this.setNome(nome);
		this.setApelido(apelido);
		this.setEmail(email);
		this.setGrauDeParentesco(grauDeParentesco);
	}
	
	public void setGrauDeParentesco(String param) {
		this.grauDeParentesco = param;
	}
	
	public String getGrauDeParentesco() {
		return this.grauDeParentesco;
	}
	
	public void confraterniza(String param) {
		System.out.println("Confraternizando com " + this.getNome() + " em " + param);
	}

}
