package lista8;

public class Livro extends Produto {
	
	private String genero;
	
	public Livro(int cod, String descricao, double preco, String genero) {
		this.setCodigo(cod);
		this.setCategoria("LIVROS");
		this.setDescricao(descricao);
		this.setGenero(genero);
		this.setPreco(preco);
	}
	
	public void setGenero(String param) {
		this.genero = param;
	}

}
