package lista9;

public abstract class Contato {
	
	private String apelido;
	private String nome;
	private String email;
	
	public void setApelido(String param) {
		this.apelido = param;
	}
	
	public void setNome(String param) {
		this.nome = param;
	}
	
	public void setEmail(String param) {
		this.email = param;
	}
	
	public String getApelido() {
		return this.apelido;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getEmail() {
		return this.email;
	}

}
