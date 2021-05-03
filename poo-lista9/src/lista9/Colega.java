package lista9;

public class Colega extends Contato {
	
	private String tipoContato;
	
	public Colega(String nome, String apelido, String email, String tipoContato) {
		this.setNome(nome);
		this.setApelido(apelido);
		this.setEmail(email);
		this.setTipoContato(tipoContato);
	}
	
	public void setTipoContato(String param) {
		this.tipoContato = param;
	}
	
	public String getTipoContato() {
		return this.tipoContato;
	}
	
	public void confraterniza(String param) {
		System.out.println("Confraternizando com " + this.getNome() + " em " + param);
	}

}
