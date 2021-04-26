package lista8;

public class Caneta extends Produto {
	
	private String cor;
	
	public Caneta(int cod, String descricao, double preco, String cor) {
		this.setCodigo(cod);
		this.setCategoria("CANETAS");
		this.setDescricao(descricao);
		this.setCor(cor);
		this.setPreco(preco);
	}
	
	public void setCor(String param) {
		this.cor = param;
	}

}

