package lista10;

public abstract class IngressoPromocional {
	
	private String nome;
	private String cpf;
	
	public void setNome(String param) {
		this.nome = param;
	}
	
	public void setCpf(String param) {
		this.cpf = param;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}

}
