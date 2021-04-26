package lista8;

public class Produto {
	
	private int codigo;
	private String categoria;
	private String descricao;
	private double preco;
	
	public void setCodigo(int param) {
		this.codigo = param;
	}
	
	public void setCategoria(String param) {
		this.categoria = param;
	}
	
	public void setPreco(double param) {
		this.preco = param;
	}
	
	public void setDescricao(String param) {
		this.descricao = param;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	


}
