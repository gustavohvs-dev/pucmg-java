package lista8;

public class Caderno extends Produto {
	
	private String tipo;
	private int numFolhas;
	
	public Caderno(int cod, String descricao, double preco, String tipo, int numFolhas) {
		this.setCodigo(cod);
		this.setCategoria("CADERNOS");
		this.setDescricao(descricao);
		this.setTipo(tipo);
		this.setNumFolhas(numFolhas);
		this.setPreco(preco);
	}
	
	public void setTipo(String param) {
		this.tipo = param;
	}
	
	public void setNumFolhas(int param) {
		this.numFolhas = param;
	}
	
}
